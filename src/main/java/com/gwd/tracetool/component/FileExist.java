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

import static com.gwd.tracetool.utils.Constants.SIMPLE_FORMATTER;

@Component
@RequiredArgsConstructor
public class FileExist {
    private final ToolProperties toolProperties;

    public boolean checkFileExist(String fileDate) {
        List<Path> filePathList = createFilePath(fileDate);
        for (Path logPath : filePathList) {
            File file = new File(logPath.toString());
            if (file.exists()==false){
                return false;
            }
        }
        return true;
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
        SIMPLE_FORMATTER.setLenient(false);
        try {
            // 대상 인자 검증
            SIMPLE_FORMATTER.parse(date);
        } catch (ParseException e) {
        }
        return String.format("dags_feign.%s.log", date);
    }

    private String generateEventFileName(String date) {
        // example : dems.2022-07-14.log
        SIMPLE_FORMATTER.setLenient(false);
        try {
            // 대상 인자 검증
            SIMPLE_FORMATTER.parse(date);
        } catch (ParseException e) {
        }
        return String.format("dems.%s.log", date);
    }
}
