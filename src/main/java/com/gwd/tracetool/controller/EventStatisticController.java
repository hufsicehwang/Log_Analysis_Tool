package com.gwd.tracetool.controller;

import com.gwd.tracetool.domain.statistic.event.DemsHostStatistic;
import com.gwd.tracetool.domain.statistic.event.EventNameStatistic;
import com.gwd.tracetool.domain.statistic.event.TimeStatistic;
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
    public EventNameStatistic calcEventName(@RequestParam String date) {
        return eventAnalysisService.calcEventName(eventParserService.readEventList(date));
    }
    @GetMapping("/api/analysis/dems-log/dems-host")
    public DemsHostStatistic calcDemsHost(@RequestParam String date) {
        return eventAnalysisService.calcDemsHost(eventParserService.readEventList(date));
    }

    @GetMapping("/api/analysis/dems-log/create-at")
    public TimeStatistic calcCreateAt(@RequestParam String date) {
        return eventAnalysisService.calcTime(eventParserService.readEventList(date));
    }


}
