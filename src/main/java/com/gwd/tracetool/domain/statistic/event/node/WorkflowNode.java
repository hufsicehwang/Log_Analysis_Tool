package com.gwd.tracetool.domain.statistic.event.node;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class WorkflowNode {
    private final String workflowType;
    @Setter
    private int count;
    @Setter
    private long avgMs;
    private final List<TransactionNode> transactionIds = new ArrayList<TransactionNode>();

    public WorkflowNode(String workflowType) {
        this.workflowType = workflowType;
    }

    public void addTransaction(TransactionNode node) {
        transactionIds.add(node);
        increaseTotalTime(node.getConsumeMs());
    }

    private void increaseTotalTime(long consumeMs) {
        avgMs += consumeMs;
    }
}
