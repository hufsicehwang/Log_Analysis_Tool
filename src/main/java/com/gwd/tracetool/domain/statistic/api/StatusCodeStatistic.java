package com.gwd.tracetool.domain.statistic.api;

import com.gwd.tracetool.domain.statistic.api.node.StatusCodeNode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class StatusCodeStatistic {
    private final List<StatusCodeNode> statusCodeNodes = new ArrayList<>();

    public void increaseStat(int statusCode) {
        for (StatusCodeNode node : statusCodeNodes) {
            if (node.getStatusCode() == statusCode) {
                node.increaseCount();
                return;
            }
        }
        StatusCodeNode node = new StatusCodeNode(statusCode);
        node.increaseCount();
        statusCodeNodes.add(node);
    }
}
