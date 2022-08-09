package com.gwd.tracetool.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EventModel {
    private String eventName;
    private String transactionId;
    private String createAt;
    private String provider;
    private String httpStatusCode;

    private int demsHost;

    private LocalDateTime occurrenceTime;

    @Builder
    public EventModel(String eventName, String transactionId, String createAt, String provider, String httpStatusCode, int demsHost, LocalDateTime occurrenceTime) {
        this.eventName = eventName;
        this.transactionId = transactionId;
        this.createAt = createAt;
        this.provider = provider;
        this.httpStatusCode = httpStatusCode;
        this.demsHost = demsHost;
        this.occurrenceTime = occurrenceTime;
    }
}
