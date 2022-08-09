package com.gwd.tracetool.service;

import com.gwd.tracetool.component.ToolProperties;
import com.gwd.tracetool.domain.EventModel;
import com.gwd.tracetool.utils.JSONUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventParserServiceImpl implements EventParserService {

    private final ToolProperties toolProperties;

    @Override
    public List readEventList(String date) {

        int demsHost = 1;
        List<EventModel> list = new ArrayList<EventModel>();
        String fileName = generateFileName(date);

        List<Path> dagsLogDirPathList = new ArrayList<>(Arrays.asList(
                Paths.get(toolProperties.getDems1LogPath(), fileName),
                Paths.get(toolProperties.getDems2LogPath(), fileName)));

        for (Path logPath : dagsLogDirPathList) {
            list.addAll(readEventLogFile(logPath, demsHost++));
        }

        return list;
    }

    private List readEventLogFile(Path path, int demsHost) {
        List<EventModel> list = new ArrayList<EventModel>();
        JSONObject headerJSON = new JSONObject();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        File file = new File(path.toString());

        String queueRecord = "receive message propertioes: MessageProperties";
        String token = "receivemessage: ";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.contains(queueRecord)) {

                    int i = line.indexOf(token) + token.length();
                    if (i != -1) {

                        LocalDateTime occurrenceTime = LocalDateTime.parse(line.substring(0, 23), formatter);
                        String subStr = line.substring(i);

                        headerJSON = stringToJSON(subStr);
                        EventModel eventModel = createEventModel(headerJSON);
                        eventModel.setOccurrenceTime(occurrenceTime);
                        eventModel.setDemsHost(demsHost);
                        list.add(eventModel);

                    }
                }
            }
        } catch (IOException e) {
            log.info("Fail to parse log : log-path={}, stack-trace={}", path, new Throwable().getStackTrace());
        }

        return list;
    }

    private EventModel createEventModel(JSONObject headerJson) {
        String eventName = JSONUtils.getEventName(headerJson);
        String workflowType = JSONUtils.getWorkflowType(headerJson);
        String createAt = JSONUtils.getCreateAt(headerJson);

        return EventModel.builder()
                .eventName(eventName)
                .workflowType(workflowType)
                .createAt(createAt)
                .build();
    }

    private String generateFileName(String date) {
        // example : dems.2022-07-14.log
        try {
            SimpleDateFormat dateFormatParser = new SimpleDateFormat("yyyy-MM-dd");
            dateFormatParser.setLenient(false);
            // 대상 인자 검증
            dateFormatParser.parse(date);
            return String.format("dems.%s.log", date);
        } catch (Exception e) {
            String yyyy = date.substring(0, 4);
            String mm = date.substring(4, 6);
            String dd = date.substring(6, 8);
            return String.format("dems.%s-%s-%s.log", yyyy, mm, dd);
        }
    }

    private JSONObject stringToJSON(String strValue) {
        JSONParser parser = new JSONParser();

        try {
            return (JSONObject) parser.parse(strValue);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
