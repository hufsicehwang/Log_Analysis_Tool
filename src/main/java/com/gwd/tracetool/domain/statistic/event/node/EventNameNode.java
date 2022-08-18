package com.gwd.tracetool.domain.statistic.event.node;

import lombok.Getter;

@Getter
public class EventNameNode implements Comparable<EventNameNode> {
    private final String eventName;
    private int count;

    public EventNameNode(String eventName) {
        this.eventName = eventName;
    }

    public void increaseCount() {
        count++;
    }

    @Override
    public int compareTo(EventNameNode o) {
        return this.eventName.compareTo(o.getEventName());
    }
}
