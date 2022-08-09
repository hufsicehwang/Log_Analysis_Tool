package com.gwd.tracetool.controller;

import com.gwd.tracetool.domain.statistic.event.EventNameStatistic;
import com.gwd.tracetool.service.EventAnalysisService;
import com.gwd.tracetool.service.EventParserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EventStatisticController {

    private final EventParserServiceImpl eventParserService;
    private final EventAnalysisService eventAnalysisService;

    @GetMapping("/api/analysis/dems-log/event-name")
    public EventNameStatistic parseDagsLog(@RequestParam String date) {
        return eventAnalysisService.calcEventName(eventParserService.readEventList(date));
    }


}
