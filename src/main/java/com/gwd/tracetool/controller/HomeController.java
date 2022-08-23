package com.gwd.tracetool.controller;

import com.gwd.tracetool.component.ToolSession;
import com.gwd.tracetool.domain.FileDateDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.runner.Request;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    private final ToolSession toolSession;

    @GetMapping("/select-date")
    public String home(HttpServletRequest request) {
        request.getSession().invalidate();
        return "/main/home";
    }

    @ResponseBody
    @PostMapping("/select-date")
    public String homeToStatistic(HttpServletRequest request) {
        String fileDate = request.getParameter("date");
        String fileExist = toolSession.checkFileExist(fileDate);

        // 해당 file date가 존재 한다면
        if (fileExist == "OK") {
            HttpSession session = request.getSession();
            session.setAttribute("fileDate", fileDate);
        }
        return fileExist;
    }
}
