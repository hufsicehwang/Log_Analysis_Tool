package com.gwd.tracetool.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EventModel implements Comparable<EventModel> {
    private String eventName;
    private String transactionId;
    private LocalDateTime createAt;
    private String provider;
    private String httpStatusCode;
    private int demsHost;
    private String workflowType;
    private LocalDateTime occurrenceTime;

    @Builder
    public EventModel(String eventName, String transactionId, LocalDateTime createAt, String provider, String httpStatusCode, String workflowType, int demsHost, LocalDateTime occurrenceTime) {
        this.eventName = eventName;
        this.transactionId = transactionId;
        this.createAt = createAt;
        this.provider = provider;
        this.httpStatusCode = httpStatusCode;
        this.workflowType = workflowType;
        this.demsHost = demsHost;
        this.occurrenceTime = occurrenceTime;
    }

    @Override
    public int compareTo(EventModel o) {
        return this.occurrenceTime.compareTo(o.getOccurrenceTime());
    }

}
