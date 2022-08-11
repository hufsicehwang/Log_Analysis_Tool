package com.gwd.tracetool.service;

import com.gwd.tracetool.domain.EventModel;
import com.gwd.tracetool.domain.statistic.event.*;

import java.util.List;

public interface EventAnalysisService {

    TimeStatistic calcTime(List<EventModel> eventModels);

    DemsHostStatistic calcDemsHost(List<EventModel> eventModels);

    EventNameStatistic calcEventName(List<EventModel> eventModels);

    WorkflowStatistic calcWorkflow(List<EventModel> eventModels);

    ConsumeTimeStatistic calcConsumeTime(List<EventModel> eventModels);

    ProviderStatistic calcProvider(List<EventModel> eventModels);


}
