package com.gwd.tracetool.domain.statistic.event.node;

import lombok.Getter;

@Getter
public class WorkflowNode {
    private final String workflowType;
    private int count;

    public WorkflowNode(String workflowType) {
        this.workflowType = workflowType;
    }

    public void increaseCount() {
        count++;
    }
}
