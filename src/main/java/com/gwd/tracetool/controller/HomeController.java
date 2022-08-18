package com.gwd.tracetool.controller;

import com.gwd.tracetool.domain.FileDateDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.runner.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/select-date")
    public String home(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("fileDate"));
        return "blank";
    }

    @PostMapping("/select-date")
    public String homeToStatistic(HttpServletRequest request) {
        System.out.println(request.getParameter("date"));
        // 해당 file date가 존재 한다면
        HttpSession session = request.getSession();
        session.setAttribute("fileDate",request.getParameter("date"));
        return "blank";
    }
}
