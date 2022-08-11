package com.gwd.tracetool.domain.statistic.event.node;

import java.util.ArrayList;
import java.util.List;

public class ErrorEventNode {

    private final String errorName;
    private int errorNameCount;

    private final String failEventName;
    private int failEventNameCount;

    private final List<String> events = new ArrayList<>();

    public ErrorEventNode(String errorName, String failEventName) {
        this.errorName = errorName;
        this.failEventName = failEventName;
    }

    public void addErrorName(String errorName){
        for(String str:events){
            if(str.equals(errorName)){
                return;
            }
        }
        events.add(errorName);
    }
}
