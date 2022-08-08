package com.gwd.tracetool.service;

import com.gwd.tracetool.domain.ApiModel;
import com.gwd.tracetool.domain.statistic.api.*;

import java.util.List;

public interface ApiAnalysisService {
    DagsHostStatistic calcDagsHost(List<ApiModel> apiModels);
    DestinationHostStatistic calcDestinationHost(List<ApiModel> apiModels);
    StatusCodeStatistic calcStatusCode(List<ApiModel> apiModels);
    TimeStatistic calcTime(List<ApiModel> apiModels);
    TypeStatistic calcType(List<ApiModel> apiModels);
}
