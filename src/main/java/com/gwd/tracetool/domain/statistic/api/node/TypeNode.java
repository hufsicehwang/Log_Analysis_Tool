package com.gwd.tracetool.domain.statistic.api.node;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeNode {
    private final String type;
    private int count;
    private int avgTime;

    public TypeNode(String type) {
        this.type = type;
    }

    public void increaseCount() {
        count++;
    }

    public void increaseAvgTime(int timeConsume) {
        avgTime += timeConsume;
    }
}
