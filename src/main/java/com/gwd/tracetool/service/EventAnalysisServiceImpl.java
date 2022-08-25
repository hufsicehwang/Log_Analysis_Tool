package com.gwd.tracetool.service;

import com.gwd.tracetool.domain.ErrorEventModel;
import com.gwd.tracetool.domain.EventModel;
import com.gwd.tracetool.domain.statistic.event.*;
import com.gwd.tracetool.domain.statistic.event.node.TransactionNode;
import com.gwd.tracetool.domain.statistic.event.node.WorkflowNode;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventAnalysisServiceImpl implements EventAnalysisService {
    @Override
    public TimeStatistic calcTime(List<EventModel> eventModels) {
        TimeStatistic stat = new TimeStatistic();
        for (EventModel model : eventModels) {
            int createAtHour = model.getCreateAt().getHour();
            stat.increaseTimeCount(createAtHour);
        }
        return stat;
    }

    @Override
    public DemsHostStatistic calcDemsHost(List<EventModel> eventModels) {
        DemsHostStatistic stat = new DemsHostStatistic();

        for (EventModel model : eventModels) {
            stat.increaseStat(model.getDemsHost());
        }
        return stat;
    }

    @Override
    public EventNameStatistic calcEventName(List<EventModel> eventModels) {
        EventNameStatistic stat = new EventNameStatistic();

        for (EventModel model : eventModels) {
            stat.increaseStat(model.getEventName());
        }

        return stat;
    }

    @Override
    public WorkflowStatistic calcWorkflow(List<EventModel> eventModels) {
        WorkflowStatistic stat = new WorkflowStatistic();
        List<TransactionNode> transactions = createTransactions(eventModels).getTransactions();

        for (TransactionNode model : transactions) {
            stat.increaseStat(model);
        }

        for (WorkflowNode node : stat.getWorkflows()) {
            node.setCount(node.getTransactions().size());
            node.setAvgMs(node.getAvgMs() / node.getCount());
        }
        return stat;
    }

    @Override
    public ConsumeTimeStatistic calcConsumeTime(List<EventModel> eventModels) {
        ConsumeTimeStatistic stat = new ConsumeTimeStatistic();
        List<TransactionNode> transactions = createTransactions(eventModels).getTransactions();

        for (TransactionNode node : transactions) {
            stat.increaseConsumeTimeCount((int) node.getConsumeMs());
        }
        return stat;
    }

    @Override
    public TransactionNode searchTransaction(List<EventModel> eventModels, String id) {
        List<TransactionNode> transactions = createTransactions(eventModels).getTransactions();

        for (TransactionNode node : transactions) {
            if (node.getTransactionId().equals(id)) {
                return node;
            }
        }
        return null;
    }

    private TransactionStatistic createTransactions(List<EventModel> eventModels) {
        TransactionStatistic stat = new TransactionStatistic();

        for (EventModel model : eventModels) {
            stat.increaseStat(model);
        }

        for (TransactionNode node : stat.getTransactions()) {
            node.setConsumeMs(node.getStartTime(), node.getEndTime());
        }
        return stat;
    }

    @Override
    public ProviderStatistic calcProvider(List<EventModel> eventModels) {
        ProviderStatistic stat = new ProviderStatistic();

        for (EventModel model : eventModels) {
            stat.increaseStat(model.getProvider());
        }
        return stat;
    }

    @Override
    public ErrorStatistic calcError(List<ErrorEventModel> errorEventModels) {
        ErrorStatistic stat = new ErrorStatistic();

        for (ErrorEventModel model : errorEventModels) {
            stat.increaseStat(model);
        }
        return stat;
    }
}
