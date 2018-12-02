package com.company.Days.Two;

import com.company.Days.DayInput;
import com.company.Reader;

import java.io.IOException;

public class DayTwoInput extends DayInput<String[]> {
    private static DayTwoInput dayTwoInput;

    private DayTwoInput() {
        super(2);
    }

    public static DayTwoInput get() {
        if (dayTwoInput == null) {
            dayTwoInput = new DayTwoInput();
        }
        return dayTwoInput;
    }

    @Override
    protected String[] loadInput(Reader reader) throws IOException {
        String[] nodes = new String[250];

        for (int i = 0; i < nodes.length && !reader.EOF(); i++) {
            nodes[i] = reader.nextLine();
        }

        return nodes;
    }
}
