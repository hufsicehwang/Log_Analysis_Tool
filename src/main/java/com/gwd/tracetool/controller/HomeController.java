package com.gwd.tracetool.controller;

import com.gwd.tracetool.component.FileExist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    private final FileExist fileExist;

    @GetMapping("/select-date")
    public String home(HttpServletRequest request) {
        request.getSession().invalidate();
        return "/main/home";
    }

    @ResponseBody
    @PostMapping("/select-date")
    public Boolean homeToStatistic(HttpServletRequest request) {
        String fileDate = request.getParameter("date");
        Boolean exist = fileExist.checkFileExist(fileDate);

        // 해당 file date가 존재 한다면 session 저장
        if (exist == true) {
            HttpSession session = request.getSession();
            session.setAttribute("fileDate", fileDate);
        }

        // in calendar.js, ajax response로 반환
        return exist;
    }
}
