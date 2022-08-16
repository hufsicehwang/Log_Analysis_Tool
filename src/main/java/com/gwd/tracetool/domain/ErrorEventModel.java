package com.gwd.tracetool.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorEventModel {

    private String errorName;
    private String failEventName;
    private String failWorkFlowType;
    private String failTransactionId;
    private int demsHost;
    private String createAt;
    private LocalDateTime occurrenceTime;

    @Builder
    public ErrorEventModel(String errorName, String failEventName, String failWorkFlowType, String failTransactionId, int demsHost, String createAt, LocalDateTime occurrenceTime) {
        this.errorName = errorName;
        this.failEventName = failEventName;
        this.failWorkFlowType = failWorkFlowType;
        this.failTransactionId = failTransactionId;
        this.demsHost = demsHost;
        this.createAt = createAt;
        this.occurrenceTime = occurrenceTime;
    }

}
