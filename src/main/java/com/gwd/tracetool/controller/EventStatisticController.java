package com.gwd.tracetool.controller;

import com.gwd.tracetool.domain.ApiModel;
import com.gwd.tracetool.domain.EventModel;
import com.gwd.tracetool.domain.statistic.event.*;
import com.gwd.tracetool.service.EventAnalysisService;
import com.gwd.tracetool.service.EventParserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventStatisticController {

    private final EventParserService eventParserService;
    private final EventAnalysisService eventAnalysisService;

    @GetMapping("/api/parse/dems-log")
    public List<EventModel> parseDemsLog(@RequestParam String date) {
        return eventParserService.readEventList(date);
    }

    @GetMapping("/api/analysis/dems-log/event-name")
    public EventNameStatistic parseDagsLog(@RequestParam String date) {
        return eventAnalysisService.calcEventName(eventParserService.readEventList(date));
    }

    @GetMapping("/api/analysis/dems-log/workflow")
    public WorkflowStatistic calcWorkflow(@RequestParam String date) {
        return eventAnalysisService.calcWorkflow(eventParserService.readEventList(date));
    }

    @GetMapping("/api/analysis/dems-log/dems-host")
    public DemsHostStatistic calcDemsHost(@RequestParam String date) {
        return eventAnalysisService.calcDemsHost(eventParserService.readEventList(date));
    }

    @GetMapping("/api/analysis/dems-log/create-at")
    public TimeStatistic calcCreateAt(@RequestParam String date) {
        return eventAnalysisService.calcTime(eventParserService.readEventList(date));
    }

    @GetMapping("/api/analysis/dems-log/consume-time")
    public ConsumeTimeStatistic calcConsumeTime(@RequestParam String date) {
        return eventAnalysisService.calcConsumeTime(eventParserService.readEventList(date));
    }

    @GetMapping("/api/analysis/dems-log/provider")
    public ProviderStatistic calcProvider(@RequestParam String date) {
        return eventAnalysisService.calcProvider(eventParserService.readEventList(date));
    }


}
