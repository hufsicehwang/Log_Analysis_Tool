package com.gwd.tracetool.domain.statistic.api;

import com.gwd.tracetool.domain.statistic.api.node.StatusCodeNode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class StatusCodeStatistic {  // 상태 코드에 따라 통계
    private final List<StatusCodeNode> codeNodeList = new ArrayList<>();

    public void increaseStat(int statusCode) {
        for (StatusCodeNode node : codeNodeList) {
            if (node.getStatusCode() == statusCode) {
                node.increaseCount();
                return;
            }
        }
        StatusCodeNode node = new StatusCodeNode(statusCode);
        node.increaseCount();
        codeNodeList.add(node);
    }
}
