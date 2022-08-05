package com.gwd.tracetool.domain.statistic.api;

import com.gwd.tracetool.domain.statistic.api.node.TypeNode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TypeStatistic {
    private final List<TypeNode> types = new ArrayList<>();

    public void increaseStat(String apiType) {
        for (TypeNode node : types) {
            if (node.getType().equals(apiType)) {
                node.increaseCount();
                return;
            }
        }
        TypeNode node = new TypeNode(apiType);
        node.increaseCount();
        types.add(node);
    }
}
