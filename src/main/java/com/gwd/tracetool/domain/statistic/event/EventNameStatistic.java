package com.gwd.tracetool.domain.statistic.event;

import com.gwd.tracetool.domain.EventModel;
import com.gwd.tracetool.domain.statistic.api.node.TypeNode;
import com.gwd.tracetool.domain.statistic.event.node.EventNameNode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class EventNameStatistic {

    private final List<EventNameNode> eventNames = new ArrayList<EventNameNode>();

    public void increaseStat(String eventName){
        for(EventNameNode node: eventNames){
            if(node.getEventName().equals(eventName)){
                node.increaseCount();
                return;
            }
        }
        EventNameNode node = new EventNameNode(eventName);
        node.increaseCount();
        eventNames.add(node);
    }



}
