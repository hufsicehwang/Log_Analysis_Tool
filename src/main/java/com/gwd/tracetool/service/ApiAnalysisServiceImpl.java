package com.gwd.tracetool.service;

import com.gwd.tracetool.domain.ApiModel;
import com.gwd.tracetool.domain.statistic.api.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiAnalysisServiceImpl implements ApiAnalysisService{

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
        return null;
    }

    @Override
    public DestinationHostStatistic calcDestinationHost(List<ApiModel> apiModels) {
        return null;
    }

    @Override
    public StatusCodeStatistic calcStatusCode(List<ApiModel> apiModels) {
        StatusCodeStatistic stat = new StatusCodeStatistic();
        for(ApiModel model:apiModels){
            stat.increaseStat(model.getCode());
        }
        return stat;
    }

    @Override
    public TypeStatistic calcType(List<ApiModel> apiModels) {
        TypeStatistic stat = new TypeStatistic();
        for(ApiModel model:apiModels){
            stat.increaseStat(model.getapiType());
        }
        return null;
    }
}
