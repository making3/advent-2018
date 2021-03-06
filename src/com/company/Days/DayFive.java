package com.company.Days;

import com.company.AdventRunner;
import com.company.Days.Five.PartOne;
import com.company.Days.Five.PartOneExample;
import com.company.Days.Five.PartTwo;
import com.company.Days.Five.PartTwoExample;
import com.company.TimedRunner;

public class DayFive extends AdventRunner {
    public DayFive() {
        super(5);
    }

    @Override
    protected void run() {
        TimedRunner tr = new TimedRunner();
        tr.run(new PartOneExample());
        tr.run(new PartOne());
        tr.run(new PartTwoExample());
        tr.run(new PartTwo());
    }
}
