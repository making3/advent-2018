package com.company.Days.Five;

import com.company.Days.DayInput;
import com.company.Reader;

import java.io.IOException;

public class DayFiveInput extends DayInput<String> {
    private static DayFiveInput dayFiveInput = null;

    private DayFiveInput() {
        super(5);
    }

    public static DayFiveInput get() {
        if (dayFiveInput == null) {
            dayFiveInput = new DayFiveInput();
        }
        return dayFiveInput;
    }

    @Override
    protected String loadInput(Reader reader) throws IOException {
        return reader.nextLine();
    }
}
