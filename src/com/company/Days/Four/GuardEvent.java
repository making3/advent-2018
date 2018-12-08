package com.company.Days.Four;

import java.time.LocalDateTime;

public class GuardEvent implements Comparable<GuardEvent> {
    public LocalDateTime EventTime;
    public String Event;

    @Override
    public int compareTo(GuardEvent o) {
        return EventTime.compareTo(o.EventTime);
    }
}
