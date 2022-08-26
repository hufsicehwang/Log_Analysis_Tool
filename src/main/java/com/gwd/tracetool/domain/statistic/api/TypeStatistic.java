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
        String type = model.getApiType();
        String host = model.getHost();

        for (TypeNode node : types) {
            if (node.getType().equals(type) && node.getHost().equals(host)) {
                node.increaseCount();
                node.increaseAvgTime(time);
                return;
            }
        }
        TypeNode node = new TypeNode(type, host);
        node.increaseCount();
        node.increaseAvgTime(time);
        types.add(node);
    }

}