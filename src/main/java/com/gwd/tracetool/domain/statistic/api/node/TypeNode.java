package com.gwd.tracetool.domain.statistic.api.node;

import lombok.Getter;

@Getter
public class TypeNode {
    private final String type;
    private Integer count;
    //private Integer totalTime;

    public TypeNode(String type) {
        this.type = type;
    }

    public void increaseCount() {
        count++;
    }

    /*public void increaseTotalTime(Integer timeConsume) {
        totalTime += timeConsume;
    }*/
}
