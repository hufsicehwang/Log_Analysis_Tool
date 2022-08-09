package com.gwd.tracetool.domain.statistic.event;

import com.gwd.tracetool.domain.statistic.event.node.ProviderNode;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ProviderStatistic {
    private final List<ProviderNode> providerNode = new ArrayList<ProviderNode>();

    public void increaseStat(String provider){
        for(ProviderNode node:providerNode){
            if(node.getProvider().equals(provider)){
                node.increaseCount();
                return;
            }
        }
        ProviderNode node = new ProviderNode(provider);
        node.increaseCount();
        providerNode.add(node);
    }
}
