package com.gwd.tracetool.controller;

import com.gwd.tracetool.domain.ErrorEventModel;
import com.gwd.tracetool.domain.EventModel;
import com.gwd.tracetool.domain.statistic.event.*;
import com.gwd.tracetool.service.EventAnalysisService;
import com.gwd.tracetool.service.EventParserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/analysis/dems-log")
public class EventStatisticController {

    private final EventParserService eventParserService;
    private final EventAnalysisService eventAnalysisService;

    @GetMapping("/api/parse/dems-log")
    public List<EventModel> parseDemsLog(@RequestParam String date) {
        return eventParserService.readEventList(date);
    }

    @GetMapping("/event-name")
    public String calcEventName(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        EventNameStatistic stat = eventAnalysisService.calcEventName(eventParserService.readEventList(session.getAttribute("fileDate").toString()));
        model.addAttribute("data",stat);
        return "EventNameTables";
    }

    @GetMapping("/workflow")
    public String calcWorkflow(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        WorkflowStatistic stat = eventAnalysisService.calcWorkflow(eventParserService.readEventList(session.getAttribute("fileDate").toString()));
        model.addAttribute("data",stat);
        return "workflow";
    }

    @GetMapping("/dems-host")
    public DemsHostStatistic calcDemsHost(@RequestParam String date) {
        return eventAnalysisService.calcDemsHost(eventParserService.readEventList(date));
    }

    @GetMapping("/create-at")
    public TimeStatistic calcCreateAt(@RequestParam String date) {
        return eventAnalysisService.calcTime(eventParserService.readEventList(date));
    }

    @GetMapping("/consume-time")
    public ConsumeTimeStatistic calcConsumeTime(@RequestParam String date) {
        return eventAnalysisService.calcConsumeTime(eventParserService.readEventList(date));
    }

    @GetMapping("/provider")
    public ProviderStatistic calcProvider(@RequestParam String date) {
        return eventAnalysisService.calcProvider(eventParserService.readEventList(date));
    }

    @GetMapping("/error")
    public List<ErrorEventModel> listUpError(@RequestParam String date) {
        return eventParserService.readErrorEventList(date);
    }


}
