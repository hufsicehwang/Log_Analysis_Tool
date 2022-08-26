package com.gwd.tracetool.domain.statistic.event;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class DemsHostStatistic {   // dems log file이 생성된 server host에 따라 통계
    private Map<Integer, Integer> demsHosts = new HashMap<Integer, Integer>();

    public void increaseStat(Integer demsHost) {
        for (Map.Entry<Integer, Integer> elem : demsHosts.entrySet()) {
            if (elem.getKey().equals(demsHost)) {
                elem.setValue(elem.getValue().intValue() + 1);
                return;
            }
        }
        demsHosts.put(demsHost, 1);
    }
}