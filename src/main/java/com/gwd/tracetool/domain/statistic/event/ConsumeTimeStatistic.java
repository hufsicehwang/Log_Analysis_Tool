package com.gwd.tracetool.domain.statistic.event;

import lombok.Getter;

@Getter
public class ConsumeTimeStatistic {     //  tansaction 별 소모 시간에 따른 통계
    private Integer gt100Ms;
    private Integer gt500Ms;
    private Integer gt1000Ms;
    private Integer gt5s;
    private Integer gt10s;
    private Integer gt30s;
    private Integer gt60s;
    private Integer gt120s;
    private Integer gt300s;
    private Integer gt600s;
    private Integer gt1200s;
    private Integer le1200s;

    public ConsumeTimeStatistic() {
        gt100Ms = 0;
        gt500Ms = 0;
        gt1000Ms = 0;
        gt5s = 0;
        gt10s = 0;
        gt30s = 0;
        gt60s = 0;
        gt120s = 0;
        gt300s = 0;
        gt600s = 0;
        gt1200s = 0;
        le1200s = 0;
    }

    public void increaseConsumeTimeCount(int msTime) {
        if (msTime < 100) {
            gt100Ms++;
        } else if (msTime < 500) {
            gt500Ms++;
        } else if (msTime < 1000) {
            gt1000Ms++;
        } else if (msTime < 1000 * 5) {
            gt5s++;
        } else if (msTime < 1000 * 10) {
            gt10s++;
        } else if (msTime < 1000 * 30) {
            gt30s++;
        } else if (msTime < 1000 * 60) {
            gt60s++;
        } else if (msTime < 1000 * 120) {
            gt120s++;
        } else if (msTime < 1000 * 300) {
            gt300s++;
        } else if (msTime < 1000 * 600) {
            gt600s++;
        } else if (msTime < 1000 * 1200) {
            gt1200s++;
        } else {
            le1200s++;
        }
    }
}
