package com.gwd.tracetool.controller;

import com.gwd.tracetool.domain.ApiModel;
import com.gwd.tracetool.domain.EventModel;
import com.gwd.tracetool.domain.statistic.event.EventNameStatistic;
import com.gwd.tracetool.service.ApiAnalysisService;
import com.gwd.tracetool.service.ApiParserService;
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

    @GetMapping("/event/parse/dems-log/eventName")
    public EventNameStatistic parseDagsLog(@RequestParam String date){
        return eventAnalysisService.calcEventName(eventParserService.readEvent(date));
    }


}
