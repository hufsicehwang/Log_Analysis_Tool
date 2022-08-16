package com.gwd.tracetool.domain.statistic.event;

import com.gwd.tracetool.domain.statistic.event.node.EventNameNode;

import java.util.ArrayList;
import java.util.List;

public class ErrorStatistic {

    private final List<EventNameNode> errorNameNodes = new ArrayList<EventNameNode>();

    public void increaseErrorNameStat(String errorName){
        for (EventNameNode errorNameNode : errorNameNodes){
            if(errorNameNode.getEventName().equals(errorName)){
                errorNameNode.increaseCount();
                return;
            }
        }
        EventNameNode errorNode = new EventNameNode(errorName);
        errorNode.increaseCount();
        errorNameNodes.add(errorNode);
    }

}
