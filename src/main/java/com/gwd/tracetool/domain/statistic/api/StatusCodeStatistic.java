package com.gwd.tracetool.domain.statistic.api;

import com.gwd.tracetool.domain.statistic.api.node.StatusCodeNode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class StatusCodeStatistic {
    private final List<StatusCodeNode> codeNodeList = new ArrayList<>();

    public void increaseStat(int statusCode) {
        for (StatusCodeNode node : codeNodeList) {  // 기존에 statusCode가 있다면 해당 노드 increaseCount
            if (node.getStatusCode() == statusCode) {
                node.increaseCount();
                return;
            }
        }
        StatusCodeNode node = new StatusCodeNode(statusCode);  // 기존에 statusCode가 없다면 해당 statusCode를 인자값으로 줘서 생성
        node.increaseCount();
        codeNodeList.add(node);
    }
}
