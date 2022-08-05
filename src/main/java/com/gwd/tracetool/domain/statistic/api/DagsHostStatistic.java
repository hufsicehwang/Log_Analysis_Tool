package com.gwd.tracetool.domain.statistic.api;

import lombok.Getter;

@Getter
public class DagsHostStatistic { // dags server 별
    private Integer dags1ApiCount;
    private Integer dags2ApiCount;

    public DagsHostStatistic() {
        this.dags1ApiCount = 0;
        this.dags2ApiCount = 0;
    }

    public void increaseDags1ApiCount() {
        dags1ApiCount++;
    }

    public void increaseDags2ApiCount() {
        dags2ApiCount++;
    }
}
