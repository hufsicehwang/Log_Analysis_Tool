package com.gwd.tracetool.domain.statistic.event.node;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class WorkflowNode {
    private final String workflowType;
    private int count;
    private long totalMs;
    private long avgMs;
    private final List<TransactionNode> transactionIds = new ArrayList<TransactionNode>();

    public WorkflowNode(String workflowType) {
        this.workflowType = workflowType;
    }

    public void increaseCount() {
        count++;
    }

    public void addTransaction(TransactionNode node) {
        transactionIds.add(node);
        increaseTotalTime(node.getConsumeMs());
    }

    private void increaseTotalTime(long consumeMms) {
        totalMs += consumeMms;
    }

    public void setAvgMs(long avgMs) {
        this.avgMs = avgMs;
    }
}
