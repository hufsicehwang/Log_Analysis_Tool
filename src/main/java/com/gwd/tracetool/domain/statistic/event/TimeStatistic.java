package com.gwd.tracetool.domain.statistic.event;

import lombok.Getter;

/**
 * -lt : <
 * -gt : >
 * -le : <=
 * -ge : >=
 * -eq : ==
 **/

@Getter
public class TimeStatistic {    // event log가 생성된 시간에 따라 통계
    private Integer gt00; // 00시<= time <02시
    private Integer gt02; // 02시<= time <04시
    private Integer gt04; // 04시<= time <06시
    private Integer gt06; // 06시<= time <08시
    private Integer gt08; // 08시<= time <10시
    private Integer gt10; // 10시<= time <12시
    private Integer gt12; // 12시<= time <14시
    private Integer gt14; // 14시<= time <16시
    private Integer gt16; // 16시<= time <18시
    private Integer gt18; // 18시<= time <20시
    private Integer gt20; // 20시<= time <22시
    private Integer gt22; // 22시<= time <24시

    public TimeStatistic() {
        this.gt00 = 0;
        this.gt02 = 0;
        this.gt04 = 0;
        this.gt06 = 0;
        this.gt08 = 0;
        this.gt10 = 0;
        this.gt12 = 0;
        this.gt14 = 0;
        this.gt16 = 0;
        this.gt18 = 0;
        this.gt20 = 0;
        this.gt22 = 0;
    }

    public void increaseTimeCount(int createAt) {
        if (createAt < 2) {
            gt00++;
        }
        else if (createAt < 4) {
            gt02++;
        }
        else if (createAt < 6) {
            gt04++;
        }
        else if (createAt < 8) {
            gt06++;
        }
        else if (createAt < 10) {
            gt08++;
        }
        else if (createAt < 12) {
            gt10++;
        }
        else if (createAt < 14) {
            gt12++;
        }
        else if (createAt < 16) {
            gt14++;
        }
        else if (createAt < 18) {
            gt16++;
        }
        else if (createAt < 20) {
            gt18++;
        }
        else if (createAt < 22) {
            gt20++;
        }
        else {
            gt22++;
        }
    }

}
