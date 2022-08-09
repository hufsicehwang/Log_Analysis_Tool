package com.gwd.tracetool.service;

import com.gwd.tracetool.domain.EventModel;
import com.gwd.tracetool.domain.statistic.event.DemsHostStatistic;
import com.gwd.tracetool.domain.statistic.event.EventNameStatistic;
import com.gwd.tracetool.domain.statistic.event.TimeStatistic;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventAnalysisServiceImpl implements EventAnalysisService {
    @Override
    public TimeStatistic calcTime(List<EventModel> eventModels) {
        TimeStatistic stat = new TimeStatistic();
        for(EventModel model : eventModels){
            int createAtHour = Integer.parseInt(model.getCreateAt().substring(11,13));
            System.out.println("hour: "+createAtHour);
            stat.increaseTimeCount(createAtHour);
        }
        return stat;
    }

    @Override
    public DemsHostStatistic calcDemsHost(List<EventModel> eventModels) {
        DemsHostStatistic stat = new DemsHostStatistic();

        for (EventModel model : eventModels) {
            if (model.getDemsHost() == 1) {
                stat.increaseDems1EventCount();
            } else {
                stat.increaseDems2EventCount();
            }
        }
        return stat;
    }

    @Override
    public EventNameStatistic calcEventName(List<EventModel> eventModels) {
        EventNameStatistic stat = new EventNameStatistic();

        for (EventModel model : eventModels) {
            stat.increaseStat(model.getEventName());
        }
        return stat;
    }
}
