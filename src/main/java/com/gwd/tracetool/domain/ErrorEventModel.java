package com.gwd.tracetool.domain;

import lombok.*;

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

    @Builder
    public ErrorEventModel(String errorName, String failEventName, String failWorkFlowType, String failTransactionId, int demsHost, String createAt) {
        this.errorName = errorName;
        this.failEventName = failEventName;
        this.failWorkFlowType = failWorkFlowType;
        this.failTransactionId = failTransactionId;
        this.demsHost = demsHost;
        this.createAt = createAt;
    }

}
