package com.gwd.tracetool.domain.statistic.api;

import lombok.Getter;

@Getter
public class DagsHostStatistic {  // dags log file이 생성된 server host에 따라 통계
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
