package com.company.Days;

import com.company.AdventRunner;
import com.company.Days.One.PartOne;
import com.company.Days.One.PartOneExample;
import com.company.Days.One.PartTwo;
import com.company.Days.One.PartTwoExample;
import com.company.TimedRunner;


public class DayOne extends AdventRunner {
    public DayOne() {
        super(1);
    }

    public void run() {
        TimedRunner tr = new TimedRunner();
        tr.run(new PartOne());
        tr.run(new PartOneExample());
        tr.run(new PartTwo());
        tr.run(new PartTwoExample());
    }
}
