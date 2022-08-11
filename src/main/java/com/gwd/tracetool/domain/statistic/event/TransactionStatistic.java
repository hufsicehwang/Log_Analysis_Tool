package com.gwd.tracetool.domain.statistic.event;

import com.gwd.tracetool.domain.EventModel;
import com.gwd.tracetool.domain.statistic.event.node.TransactionNode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TransactionStatistic {

    private final List<TransactionNode> transactions = new ArrayList<TransactionNode>();

    public void increaseStat(EventModel model) {
        for (TransactionNode node : transactions) {
            if (node.getTransactionId().equals(model.getTransactionId())) {
                node.addEvent(model.getEventName());
                node.updateTime(model.getOccurrenceTime());
                return;
            }
        }
        TransactionNode node = new TransactionNode(model.getTransactionId(), model.getWorkflowType(), model.getOccurrenceTime(), model.getOccurrenceTime());
        node.addEvent(model.getEventName());
        transactions.add(node);
    }
}
