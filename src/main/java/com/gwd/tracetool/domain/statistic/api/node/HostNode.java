package com.gwd.tracetool.domain.statistic.api.node;

import lombok.Getter;

@Getter
public class HostNode {
    private final String hostName;
    private int count;

    public HostNode(String hostName) {
        this.hostName = hostName;
    }

    public void increaseCount() {
        count++;
    }
}
