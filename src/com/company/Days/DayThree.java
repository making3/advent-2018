package com.company.Days;

import com.company.AdventRunner;
import com.company.Days.Three.Runner;
import com.company.TimedRunner;

public class DayThree extends AdventRunner {
    public DayThree() {
        super(3);
    }

    @Override
    protected void run() {
        TimedRunner tr = new TimedRunner();
        tr.run(new Runner());
    }
}
