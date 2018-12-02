package com.company;

public abstract class AdventRunner {
    protected int day;

    public AdventRunner(int day) {
        this.day = day;
    }

    public void printResults() {
        System.out.println("------------Day " + day + "------------");
        run();
    }

    protected abstract void run();
}
