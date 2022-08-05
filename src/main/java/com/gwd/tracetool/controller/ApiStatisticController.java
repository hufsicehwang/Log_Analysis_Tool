package com.gwd.tracetool.controller;

import com.gwd.tracetool.domain.ApiModel;
import com.gwd.tracetool.domain.statistic.api.*;
import com.gwd.tracetool.service.ApiAnalysisService;
import com.gwd.tracetool.service.ApiParserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiStatisticController {
    private final ApiParserService apiParserService;
    private final ApiAnalysisService apiAnalysisService;

    @GetMapping("/api/parse/dags-log")
    public List<ApiModel> parseDagsLog(@RequestParam String date){
        return apiParserService.readApi(date);
    }

    @GetMapping("/api/analyze/dags-log/time-consume")
    public TimeStatistic calcTime(@RequestParam String date){
        return apiAnalysisService.calcTime(apiParserService.readApi(date));
    }

    @GetMapping("/api/analyze/dags-log/destination-host")
    public DestinationHostStatistic calcDestinationHost(@RequestParam(value = "yyyymmdd") String date){
        return apiAnalysisService.calcDestinationHost(apiParserService.readApi(date));
    }

    @GetMapping("/api/analyze/dags-log/status-code")
    public StatusCodeStatistic calcStatusCode(@RequestParam(value = "yyyymmdd") String date){
        return apiAnalysisService.calcStatusCode(apiParserService.readApi(date));
    }

    @GetMapping("/api/analyze/dags-log/")
    public DagsHostStatistic calcDagsHost(@RequestParam(value = "yyyymmdd") String date){
        return apiAnalysisService.calcDagsHost(apiParserService.readApi(date));
    }

    @GetMapping("/api/analyze/dags-log/api-type")
    public TypeStatistic calcType(@RequestParam(value = "yyyymmdd") String date){
        return apiAnalysisService.calcType(apiParserService.readApi(date));
    }
}
