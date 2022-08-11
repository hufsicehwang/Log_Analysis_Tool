package com.gwd.tracetool.domain.statistic.event.node;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class WorkflowNode {
    private final String workflowType;
    private int count;
    private long totalMms;
    private long avgMms;
    private final List<TransactionNode> transactionIds = new ArrayList<TransactionNode>();

    public WorkflowNode(String workflowType) {
        this.workflowType = workflowType;
    }

    public void increaseCount() {
        count++;
    }

    public void addTransaction(TransactionNode node) {
        transactionIds.add(node);
        increaseTotalTime(node.getConsumeMms());
    }

    private void increaseTotalTime(long consumeMms) {
        totalMms += consumeMms;
    }

    public void setAvgMms(long avgMms) {
        this.avgMms = avgMms;
    }
}
