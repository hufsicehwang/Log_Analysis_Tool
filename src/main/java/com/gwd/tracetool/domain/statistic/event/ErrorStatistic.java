package com.gwd.tracetool.domain.statistic.event;

import com.gwd.tracetool.domain.statistic.event.node.EventNameNode;

import java.util.ArrayList;
import java.util.List;

public class ErrorStatistic {

    private final List<EventNameNode> errorNameNodes = new ArrayList<EventNameNode>();
    //private final List<EventNameNode> failEventNameNodes = new ArrayList<EventNameNode>();

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
//    public void increaseFailEventStat(String failEventName){
//        for (EventNameNode failEvenNode : failEventNameNodes){
//            if(failEvenNode.getEventName().equals(failEventName)){
//                failEvenNode.increaseCount();
//                return;
//            }
//        }
//        EventNameNode failNode = new EventNameNode(failEventName);
//        failNode.increaseCount();
//        failEventNameNodes.add(failNode);
//    }

}
