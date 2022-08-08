package com.gwd.tracetool.service;

import com.gwd.tracetool.domain.ApiModel;
import com.gwd.tracetool.domain.statistic.api.*;
import com.gwd.tracetool.domain.statistic.api.node.TypeNode;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiAnalysisServiceImpl implements ApiAnalysisService {

    @Override
    public TimeStatistic calcTime(List<ApiModel> apiModels) {
        TimeStatistic stat = new TimeStatistic();
        for (ApiModel model : apiModels) {
            stat.increaseTimeCount(model.getTime());
        }
        return stat;
    }

    @Override
    public DagsHostStatistic calcDagsHost(List<ApiModel> apiModels) {

        DagsHostStatistic stat = new DagsHostStatistic();
        for (ApiModel model : apiModels) {

            if (model.getLogOffset() == 1) {
                stat.increaseDags1ApiCount();
            } else {
                stat.increaseDags2ApiCount();
            }
        }
        return stat;
    }

    @Override
    public DestinationHostStatistic calcDestinationHost(List<ApiModel> apiModels) {
        DestinationHostStatistic stat = new DestinationHostStatistic();
        for (ApiModel model : apiModels) {
            stat.increaseStat(model.getHost());
        }
        return stat;
    }

    @Override
    public StatusCodeStatistic calcStatusCode(List<ApiModel> apiModels) {
        StatusCodeStatistic stat = new StatusCodeStatistic();
        for (ApiModel model : apiModels) {
            stat.increaseStat(model.getCode());
        }
        return stat;
    }

    @Override
    public TypeStatistic calcType(List<ApiModel> apiModels) {
        TypeStatistic stat = new TypeStatistic();
        for (ApiModel model : apiModels) {
            stat.increaseStat(model.getApiType(), model.getTime());
        }

        for (TypeNode type : stat.getTypes()) {
            type.setAvgTime(type.getAvgTime() / type.getCount());
        }

        return stat;
    }
}
