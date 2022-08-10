package com.gwd.tracetool.domain.statistic.event;

import com.gwd.tracetool.domain.statistic.event.node.WorkflowNode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class WorkflowStatistic { // work flow type을 name에 따라 통계
    private final List<WorkflowNode> workflows = new ArrayList<WorkflowNode>();

    public void increaseStat(String workflowType) {
        for (WorkflowNode node : workflows) {
            if (node.getWorkflowType().equals(workflowType)) {
                node.increaseCount();
                return;
            }
        }
        WorkflowNode node = new WorkflowNode(workflowType);
        node.increaseCount();
        workflows.add(node);
    }
}
