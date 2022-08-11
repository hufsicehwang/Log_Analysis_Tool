package com.gwd.tracetool.domain.statistic.event;

import com.gwd.tracetool.domain.statistic.event.node.TransactionNode;
import com.gwd.tracetool.domain.statistic.event.node.WorkflowNode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class WorkflowStatistic {

    private final List<WorkflowNode> workflows = new ArrayList<WorkflowNode>();

    public void increaseStat(TransactionNode model) {
        for (WorkflowNode node : workflows) {
            if (node.getWorkflowType().equals(model.getWorkflowType())) {
                node.increaseCount();
                node.addTransaction(model);
                return;
            }
        }
        WorkflowNode node = new WorkflowNode(model.getWorkflowType());
        node.increaseCount();
        node.addTransaction(model);
        workflows.add(node);
    }


}
