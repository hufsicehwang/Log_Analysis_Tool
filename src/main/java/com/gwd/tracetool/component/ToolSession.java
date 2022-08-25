package com.gwd.tracetool.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.gwd.tracetool.utils.Constants.simpleFormatter;

//    dags1: C:\Users\User\Desktop\log\dags1
//            dags2: C:\Users\User\Desktop\log\dags2
//            dems1: C:\Users\User\Desktop\log\dems1\trace
//            dems2: C:\Users\User\Desktop\log\dems2\trace

@Component
@RequiredArgsConstructor
public class ToolSession {
    private final ToolProperties toolProperties;

    public String checkFileExist(String fileDate) {
        List<Path> filePathList = createFilePath(fileDate);
        for (Path logPath : filePathList) {
            File file = new File(logPath.toString());
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            } catch (FileNotFoundException e) {
                return "File Not Found";
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "OK";
    }

    private List<Path> createFilePath(String fileDate) {
        String apiFileName = generateApiFileName(fileDate);
        String eventFileName = generateEventFileName(fileDate);

        return new ArrayList<>(Arrays.asList(
                Paths.get(toolProperties.getDags1LogPath(), apiFileName),
                Paths.get(toolProperties.getDags2LogPath(), apiFileName),
                Paths.get(toolProperties.getDems1LogPath(), eventFileName),
                Paths.get(toolProperties.getDems2LogPath(), eventFileName)
        ));
    }

    private String generateApiFileName(String date) {
        // example : dags_feign.2022-07-14.log
        simpleFormatter.setLenient(false);
        try {
            // 대상 인자 검증
            simpleFormatter.parse(date);
        } catch (ParseException e) {
        }
        return String.format("dags_feign.%s.log", date);
    }

    private String generateEventFileName(String date) {
        // example : dems.2022-07-14.log
        simpleFormatter.setLenient(false);
        try {
            // 대상 인자 검증
            simpleFormatter.parse(date);
        } catch (ParseException e) {
        }
        return String.format("dems.%s.log", date);
    }
}
