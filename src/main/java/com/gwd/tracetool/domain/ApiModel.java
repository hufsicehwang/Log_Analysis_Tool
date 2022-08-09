package com.gwd.tracetool.domain;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiModel implements Comparable<ApiModel> {
    private LocalDateTime occurrenceTime;
    private Integer dagsHost;
    private String host;
    private String apiType;
    private Integer code;
    private String time;
    private String message;
    private String body;

    @Builder
    public ApiModel(LocalDateTime occurrenceTime, Integer dagsHost, String host, String apiType, Integer code, String time, String message, String body) {
        this.occurrenceTime = occurrenceTime;
        this.dagsHost = dagsHost;
        this.host = host;
        this.apiType = apiType;
        this.code = code;
        this.time = time;
        this.message = message;
        this.body = body;
    }


    @Override
    public int compareTo(ApiModel o) {
        return this.occurrenceTime.compareTo(o.getOccurrenceTime());
    }

}
