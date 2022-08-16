package com.gwd.tracetool.controller;

import com.gwd.tracetool.domain.ApiModel;
import com.gwd.tracetool.domain.statistic.api.*;
import com.gwd.tracetool.service.ApiAnalysisService;
import com.gwd.tracetool.service.ApiParserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiStatisticController {
    private final ApiParserService apiParserService;
    private final ApiAnalysisService apiAnalysisService;

    @GetMapping("/api/parse/dags-log")
    public List<ApiModel> parseDagsLog(@RequestParam String date) {
        return apiParserService.readApiList(date);
    }

    @GetMapping("/api/analysis/dags-log/time-consume")
    public TimeStatistic calcTime(@RequestParam String date) {
        return apiAnalysisService.calcTime(apiParserService.readApiList(date));
    }

    @GetMapping("/api/analysis/dags-log/destination-host")
    public DestinationHostStatistic calcDestinationHost(@RequestParam String date) {
        return apiAnalysisService.calcDestinationHost(apiParserService.readApiList(date));
    }

    @RequestMapping("/api/analysis/dags-log/status-code")
    public StatusCodeStatistic calcStatusCode(@RequestParam String date, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("session",date);
        return apiAnalysisService.calcStatusCode(apiParserService.readApiList(date));
    }

    @GetMapping("/api/analysis/dags-log/dags-host")
    public DagsHostStatistic calcDagsHost(@RequestParam String date) {
        return apiAnalysisService.calcDagsHost(apiParserService.readApiList(date));
    }

    @GetMapping("/api/analysis/dags-log/api-type")
    public TypeStatistic calcType(@RequestParam String date) {
        return apiAnalysisService.calcType(apiParserService.readApiList(date));
    }
}
