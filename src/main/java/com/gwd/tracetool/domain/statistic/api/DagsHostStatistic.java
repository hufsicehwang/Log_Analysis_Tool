package com.gwd.tracetool.domain.statistic.api;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class DagsHostStatistic {  // dags log file이 생성된 server host에 따라 통계
    private Map<Integer, Integer> dagsHosts = new HashMap<Integer, Integer>();

    public void increaseStat(Integer demsHost) {
        for (Map.Entry<Integer, Integer> elem : dagsHosts.entrySet()) {
            if (elem.getKey().equals(demsHost)) {
                elem.setValue(elem.getValue().intValue() + 1);
                return;
            }
        }
        dagsHosts.put(demsHost, 1);
    }
}
