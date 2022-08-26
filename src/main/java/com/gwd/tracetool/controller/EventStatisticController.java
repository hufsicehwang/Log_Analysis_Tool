package com.gwd.tracetool.controller;

import com.gwd.tracetool.domain.ErrorEventModel;
import com.gwd.tracetool.domain.statistic.event.*;
import com.gwd.tracetool.service.EventAnalysisService;
import com.gwd.tracetool.service.EventParserService;
import com.gwd.tracetool.utils.ScriptUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/analysis/dems-log")
public class EventStatisticController {

    private final EventParserService eventParserService;
    private final EventAnalysisService eventAnalysisService;

    @GetMapping("/event-name")
    public String calcEventName(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        try {
            HttpSession session = request.getSession();
            EventNameStatistic stat = eventAnalysisService.calcEventName(eventParserService.readEventList(session.getAttribute("fileDate").toString()));
            model.addAttribute("data", stat);
        } catch (NullPointerException e) {
            ScriptUtils.alertAndRender(response, "File Date를 먼저 선택해 주세요.", "/home/select-date");
        }
        return "/event/eventName_table";
    }

    @GetMapping("/workflow")
    public String calcWorkflow(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        try {
            HttpSession session = request.getSession();
            WorkflowStatistic stat = eventAnalysisService.calcWorkflow(eventParserService.readEventList(session.getAttribute("fileDate").toString()));
            model.addAttribute("data", stat);
        } catch (NullPointerException e) {
            ScriptUtils.alertAndRender(response, "File Date를 먼저 선택해 주세요.", "/home/select-date");
        }

        return "event/workflow_table";
    }

    @GetMapping("/dems-host")
    public String calcDemsHost(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        try {
            HttpSession session = request.getSession();
            DemsHostStatistic stat = eventAnalysisService.calcDemsHost(eventParserService.readEventList(session.getAttribute("fileDate").toString()));
            model.addAttribute("data", stat);
        } catch (NullPointerException e) {
            ScriptUtils.alertAndRender(response, "File Date를 먼저 선택해 주세요.", "/home/select-date");
        }
        return "event/demsHostServer_table";
    }

    @GetMapping("/create-at")
    public String calcCreateAt(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        try {
            HttpSession session = request.getSession();
            TimeStatistic stat = eventAnalysisService.calcTime(eventParserService.readEventList(session.getAttribute("fileDate").toString()));
            model.addAttribute("data", stat);
        } catch (NullPointerException e) {
            ScriptUtils.alertAndRender(response, "File Date를 먼저 선택해 주세요.", "/home/select-date");
        }
        return "event/createdTime_table";
    }

    @GetMapping("/consume-time")
    public String calcConsumeTime(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        try {
            HttpSession session = request.getSession();
            ConsumeTimeStatistic stat = eventAnalysisService.calcConsumeTime(eventParserService.readEventList(session.getAttribute("fileDate").toString()));
            model.addAttribute("data", stat);
        } catch (NullPointerException e) {
            ScriptUtils.alertAndRender(response, "File Date를 먼저 선택해 주세요.", "/home/select-date");
        }
        return "event/consumeTime_table";
    }

    @GetMapping("/provider")
    public String calcProvider(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        try {
            HttpSession session = request.getSession();
            ProviderStatistic stat = eventAnalysisService.calcProvider(eventParserService.readEventList(session.getAttribute("fileDate").toString()));
            model.addAttribute("data", stat);
        } catch (NullPointerException e) {
            ScriptUtils.alertAndRender(response, "File Date를 먼저 선택해 주세요.", "/home/select-date");
        }
        return "event/provider_table";
    }

    @GetMapping("/error")
    public String listUpError(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        try {
            HttpSession session = request.getSession();
            List<ErrorEventModel> list = eventParserService.readErrorEventList(session.getAttribute("fileDate").toString());
            model.addAttribute("data", list);
        } catch (NullPointerException e) {
            ScriptUtils.alertAndRender(response, "File Date를 먼저 선택해 주세요.", "/home/select-date");
        }
        return "event/errorEvent_table";
    }

}
