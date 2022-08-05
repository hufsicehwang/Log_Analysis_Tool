package com.gwd.tracetool.domain.statistic.api.node;

import lombok.Getter;

@Getter
public class StatusCodeNode {
    private final Integer statusCode;
    private Integer count;

    public StatusCodeNode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void increaseCount() {
        count++;
    }
}
