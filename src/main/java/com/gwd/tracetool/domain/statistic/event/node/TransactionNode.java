package com.gwd.tracetool.domain.statistic.event.node;

import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Getter
public class TransactionNode {

    private final String transactionId;
    private final String workflowType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long consumeMs;
    private final List<String> events = new ArrayList<String>();

    public TransactionNode(String transactionId, String workflowType, LocalDateTime startTime, LocalDateTime endTime) {
        this.transactionId = transactionId;
        this.workflowType = workflowType;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void addEvent(String eventName) {
        for (String node : events) {
            if (node.equals(eventName)) {
                return;
            }
        }
        events.add(eventName);
    }

    public void updateTime(LocalDateTime occurrenceTime) {
        if (occurrenceTime.isBefore(this.startTime)) {
            this.startTime = occurrenceTime;
        }

        if (occurrenceTime.isAfter(this.endTime)) {
            this.endTime = occurrenceTime;
        }
    }

    public void setConsumeTime(LocalDateTime startTime, LocalDateTime endTime) {
        Duration duration = Duration.between(startTime, endTime);
        long calcMs =  TimeUnit.MILLISECONDS.convert(duration);
        this.consumeMs = calcMs;
    }
}
