package com.company.Days;

import com.company.Reader;

import java.io.IOException;

public abstract class DayInput<TInput> {
    private int day;
    private TInput cachedInput;

    public DayInput(int day) {
        this.day = day;
    }

    public TInput getInput() {
        if (cachedInput != null) {
            return cachedInput;
        }
        try {
            Reader reader = new Reader(day);
            cachedInput = loadInput(reader);
        } catch (Exception e) {
            System.out.println("Exception reading file " + e);
        }
        return cachedInput;
    }

    protected abstract TInput loadInput(Reader reader) throws IOException;
}
