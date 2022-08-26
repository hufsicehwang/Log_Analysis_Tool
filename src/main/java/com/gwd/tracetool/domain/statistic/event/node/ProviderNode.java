package com.gwd.tracetool.domain.statistic.event.node;

import lombok.Getter;

@Getter
public class ProviderNode {
    private final String provider;
    private int count;

    public ProviderNode(String provider) {
        this.provider = provider;
    }

    public void increaseCount() {
        count++;
    }
}
