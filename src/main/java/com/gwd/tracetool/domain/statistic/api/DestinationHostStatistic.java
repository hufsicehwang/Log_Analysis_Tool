package com.gwd.tracetool.domain.statistic.api;

import com.gwd.tracetool.domain.statistic.api.node.HostNode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DestinationHostStatistic {  // 목적지 host에 따라 통계
    private final List<HostNode> destinationHosts = new ArrayList<>();

    public void increaseStat(String nodeName) {
        for (HostNode node : destinationHosts) {
            if (node.getHostName().equals(nodeName)) {
                node.increaseCount();
                return;
            }
        }
        HostNode node = new HostNode(nodeName);
        node.increaseCount();
        destinationHosts.add(node);
    }
}
