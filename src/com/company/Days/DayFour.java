package com.company.Days;

import com.company.AdventRunner;
import com.company.Days.Four.PartOne;
import com.company.TimedRunner;

public class DayFour extends AdventRunner {
    public DayFour() {
        super(4);
    }

    @Override
    protected void run() {
        TimedRunner tr = new TimedRunner();
        tr.run(new PartOne());
    }
}
