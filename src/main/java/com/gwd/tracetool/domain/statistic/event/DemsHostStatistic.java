package com.gwd.tracetool.domain.statistic.event;

import lombok.Getter;

@Getter
public class DemsHostStatistic {   // dags log file이 생성된 server host에 따라 통계
    private Integer dems1EventCount;
    private Integer dems2EventCount;

    public DemsHostStatistic() {
        this.dems1EventCount = 0;
        this.dems2EventCount = 0;
    }

    public void increaseDems1EventCount() {
        dems1EventCount++;
    }

    public void increaseDems2EventCount() {
        dems2EventCount++;
    }
}
