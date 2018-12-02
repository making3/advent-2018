package com.company;

import java.io.FileNotFoundException;

public abstract class AdventRunner {
    protected int _day;

    public AdventRunner(int day) {
        _day = day;
    }

    public void printResults() {
        System.out.println("------------Day " + _day + "------------");
        this.run();
    }

    protected abstract void run();
    protected Reader getReader() throws FileNotFoundException {
        return new Reader(_day);
    }
}
