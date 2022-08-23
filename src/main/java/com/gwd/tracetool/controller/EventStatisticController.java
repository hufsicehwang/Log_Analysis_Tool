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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.model.IModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/analysis/dems-log")
public class EventStatisticController {

    private final EventParserService eventParserService;
    private final EventAnalysisService eventAnalysisService;

    @GetMapping("/event-name")
    public String calcEventName(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        EventNameStatistic stat = eventAnalysisService.calcEventName(eventParserService.readEventList(session.getAttribute("fileDate").toString()));
        model.addAttribute("data",stat);
        return "/event/eventName_table";
    }

    @GetMapping("/workflow")
    public WorkflowStatistic calcWorkflow(@RequestParam String date) {
        return eventAnalysisService.calcWorkflow(eventParserService.readEventList(date));
    }

    @GetMapping("/dems-host")
    public String calcDemsHost(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        DemsHostStatistic stat = eventAnalysisService.calcDemsHost(eventParserService.readEventList(session.getAttribute("fileDate").toString()));
        model.addAttribute("data",stat);
        return "event/demsHostServer_table";
    }

    @GetMapping("/create-at")
    public String calcCreateAt(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        TimeStatistic stat = eventAnalysisService.calcTime(eventParserService.readEventList(session.getAttribute("fileDate").toString()));
        model.addAttribute("data",stat);
        return "event/createdTime_table";
    }

    @GetMapping("/consume-time")
    public String calcConsumeTime(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        ConsumeTimeStatistic stat = eventAnalysisService.calcConsumeTime(eventParserService.readEventList(session.getAttribute("fileDate").toString()));
        model.addAttribute("data",stat);
        return "event/consumeTime_table";
    }

    @GetMapping("/provider")
    public String calcProvider(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        ProviderStatistic stat = eventAnalysisService.calcProvider(eventParserService.readEventList(session.getAttribute("fileDate").toString()));
        model.addAttribute("data",stat);
        return "event/provider_table";
    }

    @GetMapping("/error")
    public String listUpError(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        List<ErrorEventModel> list =  eventParserService.readErrorEventList(session.getAttribute("fileDate").toString());
        model.addAttribute("data",list);
        return "event/errorEvent_table";
    }


}
