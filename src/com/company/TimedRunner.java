package com.company;

public class TimedRunner {
    public void run(AdventRun adventRun) {
        Object input = adventRun.getInput();
        final long startTime = System.currentTimeMillis();
        String result = adventRun.run(input);
        final long endTime = System.currentTimeMillis();
        System.out.println(adventRun.getRunName() + ": " + result);
        System.out.println(">>>Total execution time: " + (endTime - startTime));
    }
}
