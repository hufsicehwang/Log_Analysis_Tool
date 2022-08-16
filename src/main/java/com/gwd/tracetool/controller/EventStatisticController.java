package com.gwd.tracetool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.gwd.tracetool.domain.ErrorEventModel;
import com.gwd.tracetool.domain.EventModel;
import com.gwd.tracetool.domain.statistic.event.*;
import com.gwd.tracetool.service.EventAnalysisService;
import com.gwd.tracetool.service.EventParserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.model.IModel;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EventStatisticController {

    private final EventParserService eventParserService;
    private final EventAnalysisService eventAnalysisService;

    @GetMapping("/api/parse/dems-log")
    public List<EventModel> parseDemsLog(@RequestParam String date) {
        return eventParserService.readEventList(date);
    }

//    @GetMapping("/api/analysis/dems-log/event-name")
//    public EventNameStatistic calcEventName(@RequestParam String date) {
//        return eventAnalysisService.calcEventName(eventParserService.readEventList(date));
//    }
    @GetMapping("/api/analysis/dems-log/event-name")
    public String calcEventName(@RequestParam String date, Model model) {
        EventNameStatistic stat = eventAnalysisService.calcEventName(eventParserService.readEventList(date));
        for(int i =0; i<stat.getEventNames().size();i++){
            System.out.println("event name : "+stat.getEventNames().get(i).getEventName());
        }

        model.addAttribute("data",stat);
        return "tables";
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

    @GetMapping("/api/analysis/dems-log/error")
    public List<ErrorEventModel> listUpError(@RequestParam String date) {
        return eventParserService.readErrorEventList(date);
    }


}
