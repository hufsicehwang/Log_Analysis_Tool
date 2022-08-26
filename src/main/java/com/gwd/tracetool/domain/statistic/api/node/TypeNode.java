package com.gwd.tracetool.domain.statistic.api.node;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeNode {
    private final String type;
    private final String host;
    private int count;
    private int avgMs;

    public TypeNode(String type, String host) {
        this.type = type;
        this.host = host;
    }

    public void increaseCount() {
        count++;
    }

    public void increaseAvgTime(int timeConsume) {
        avgMs += timeConsume;
    }
}
