package com.gwd.tracetool.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gwd.tracetool.component.ToolProperties;
import com.gwd.tracetool.domain.ApiModel;
import com.gwd.tracetool.domain.EventModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import com.gwd.tracetool.utils.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventParserService {

    private final ToolProperties toolProperties;

    public EventModel createEventModel(JSONObject headerJson){
        System.out.println("value : "+JSONUtils.getEventName(headerJson));
        String eventName = JSONUtils.getEventName(headerJson);

        return EventModel.builder().eventName(eventName).build();
    }

    private List readEventLogFile(Path path, int logOffset) {
        List<EventModel> list = new ArrayList<EventModel>();
        JSONObject headerJSON  = new JSONObject();
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

                        headerJSON = JSONTransfer.stringToJSON(subStr);
                        EventModel eventModel = createEventModel(headerJSON);
                        eventModel.setOccurrenceTime(occurrenceTime);
                        eventModel.setLogOffset(logOffset);
                        list.add(eventModel);

                    }
                }
            }
        } catch (IOException e) {
            log.info("Fail to parse log : log-path={}, stack-trace={}", path, new Throwable().getStackTrace());
        }

        return list;
    }

//    public static String getEventName(Map map) {
//        Map map2 = (Map) map.get("header");
//        Map map3 = (Map) map2.get("event");
//        return (String) map3.get("eventName");
//    }
//
//    public static String getCreateAt(Map map) {
//        Map map2 = (Map) map.get("header");
//        Map map3 = (Map) map2.get("event");
//        return (String) map3.get("createAt");
//    }
//
//    public static String getTransactionId(Map map) {
//        Map map2 = (Map) map.get("header");
//        Map map3 = (Map) map2.get("workflow");
//        return (String) map3.get("transactionId");
//    }
//
//    public static String getStatusCode(Map map) {
//        Map map2 = (Map) map.get("header");
//        Map map3 = (Map) map2.get("amqResponseInfo");
//        String httpStatusCode;
//        try {
//            httpStatusCode = (String) map3.get("httpStatusCode").toString();
//        } catch (NullPointerException e) {
//            httpStatusCode = "NULL";
//        }
//        return httpStatusCode;
//    }


    private String generateFileName(String date) {
        // example : dems_feign.2022-07-14.log
        return String.format("dems.%s.log", date);
    }

    public List readEvent(String date) {

        int offset = 1;
        List<EventModel> list = new ArrayList<EventModel>();
        String fileName = generateFileName(date);

        List<Path> dagsLogDirPathList = new ArrayList<>(Arrays.asList(
                Paths.get(toolProperties.getDems1LogPath(), fileName),
                Paths.get(toolProperties.getDems2LogPath(), fileName)));

        for (Path logPath : dagsLogDirPathList) {
            list.addAll(readEventLogFile(logPath, offset++));
        }



        return list;
    }
}
