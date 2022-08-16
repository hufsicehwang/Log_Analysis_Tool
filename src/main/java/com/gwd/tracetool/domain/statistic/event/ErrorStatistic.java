package com.gwd.tracetool.domain.statistic.event;

import com.gwd.tracetool.domain.ErrorEventModel;
import com.gwd.tracetool.domain.statistic.event.node.ErrorEventNode;

import java.util.ArrayList;
import java.util.List;

public class ErrorStatistic {

    private final List<ErrorEventNode> errorNameNodes = new ArrayList<ErrorEventNode>();


    public void increaseStat(ErrorEventModel models){
        for (ErrorEventNode node : errorNameNodes){
            if(node.getErrorName().equals(models.getErrorName())){
                node.increaseErrNameCount();
                return;
            }
        }
        ErrorEventNode node = new ErrorEventNode(models.getErrorName(), models.getFailEventName());
        errorNameNodes.add(node);
    }
//    public void increaseFailEventStat(String failEventName){
//        for (ErrorEventNode failEvenNode : failErrorEventNodes){
//            if(failEvenNode.getEventName().equals(failEventName)){
//                failEvenNode.increaseCount();
//                return;
//            }
//        }
//        ErrorEventNode failNode = new ErrorEventNode(failEventName);
//        failNode.increaseCount();
//        failErrorEventNodes.add(failNode);
//    }

}
