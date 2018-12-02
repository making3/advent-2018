package com.company;

import java.io.FileNotFoundException;

public abstract class AdventRunner<TInput> {
    protected int _day;

    public AdventRunner(int day) {
        _day = day;
    }

    public void printResults() {
        System.out.println("------------Day " + _day + "------------");
        TInput input = getInput();
        System.out.println("Part 1 - Example: " + partOne(getPartOneExampleInput()));
        System.out.println("Part 1: " + partOne(input));
        System.out.println("Part 2 - Example: " + partTwo(getPartTwoExampleInput()));
        System.out.println("Part 2: " + partTwo(input));
    }

    protected Reader getReader() throws FileNotFoundException {
        return new Reader(_day);
    }

    protected abstract TInput getInput();

    protected abstract String partOne(TInput input);
    protected abstract String partTwo(TInput input);

    protected abstract TInput getPartOneExampleInput();
    protected abstract TInput getPartTwoExampleInput();
}
