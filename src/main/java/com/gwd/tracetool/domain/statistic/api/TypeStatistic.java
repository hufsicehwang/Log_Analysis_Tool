package com.gwd.tracetool.domain.statistic.api;

import com.gwd.tracetool.domain.ApiModel;
import com.gwd.tracetool.domain.statistic.api.node.TypeNode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TypeStatistic { // api 종류에 따라 통계
    private final List<TypeNode> types = new ArrayList<>();

    public void increaseStat(ApiModel model) {
        int time = Integer.parseInt(model.getTime().replace("ms", ""));

        for (TypeNode node : types) {
            if (node.getType().equals(model.getApiType())) {
                node.increaseCount();
                node.increaseAvgTime(time);
                return;
            }
        }
        TypeNode node = new TypeNode(model.getApiType(), model.getHost());
        node.increaseCount();
        node.increaseAvgTime(time);
        types.add(node);
    }

}
