package com.gwd.tracetool.service;

import com.gwd.tracetool.domain.EventModel;
import com.gwd.tracetool.domain.statistic.event.DemsHostStatistic;
import com.gwd.tracetool.domain.statistic.event.EventNameStatistic;
import com.gwd.tracetool.domain.statistic.event.TimeStatistic;

import java.util.List;

public interface EventAnalysisService {

    TimeStatistic calcTime(List<EventModel> eventModels);

    DemsHostStatistic calcDemsHost(List<EventModel> eventModels);

    EventNameStatistic calcEventName(List<EventModel> eventModels);

}
