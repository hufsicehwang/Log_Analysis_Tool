package com.gwd.tracetool.domain.statistic.api;

import com.gwd.tracetool.domain.statistic.api.node.TypeNode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TypeStatistic {
    private final List<TypeNode> types = new ArrayList<>();

    public void increaseStat(String apiType, String msTime) {
        increaseStat(apiType, Integer.parseInt(msTime.replace("ms", "")));
    }

    public void increaseStat(String apiType, int time) {
        for (TypeNode node : types) {
            if (node.getType().equals(apiType)) {
                node.increaseCount();
                node.increaseAvgTime(time);
                return;
            }
        }
        TypeNode node = new TypeNode(apiType);
        node.increaseCount();
        node.increaseAvgTime(time);
        types.add(node);
    }

}
