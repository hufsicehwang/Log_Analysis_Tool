package com.gwd.tracetool.domain.statistic.event;

public class DemsHostStatistic {

    private Integer dems1EventCount;
    private Integer dems2EventCount;

    public DemsHostStatistic() {
        this.dems1EventCount = 0;
        this.dems2EventCount = 0;
    }

    public void increaseDems1EventCount(){
        dems1EventCount++;
    }
    public void increaseDems2EventCount(){
        dems2EventCount++;
    }
}
