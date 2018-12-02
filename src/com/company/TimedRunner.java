package com.company;

public class TimedRunner {
    public void run(AdventRun adventRun) {
        final long startTime = System.currentTimeMillis();
        String result = adventRun.run(adventRun.getInput());
        System.out.println(adventRun.getRunName() + ": " + result);
        final long endTime = System.currentTimeMillis();
        System.out.println(">>>Total execution time: " + (endTime - startTime));
    }
}
