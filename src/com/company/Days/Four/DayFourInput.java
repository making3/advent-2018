package com.company.Days.Four;

import com.company.Days.DayInput;
import com.company.Reader;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class DayFourInput extends DayInput<ArrayList<GuardEvent>> {
    private static DayFourInput dayFourInput = null;

    private DayFourInput() {
        super(4);
    }

    public static DayFourInput get() {
        if (dayFourInput == null) {
            dayFourInput = new DayFourInput();
        }
        return dayFourInput;
    }

    @Override
    protected ArrayList<GuardEvent> loadInput(Reader reader) throws IOException {
        String line;
        ArrayList<GuardEvent> events = new ArrayList<>(1096);

        while ((line = reader.nextLine()) != null) {
            GuardEvent event = new GuardEvent();
            event.Event = line.substring(19);
            event.EventTime = getEventDate(line);
            events.add(event);
        }

        Collections.sort(events);
        return events;
    }

    private LocalDateTime getEventDate(String line) {
        return LocalDateTime.parse(line.substring(1, 17), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
