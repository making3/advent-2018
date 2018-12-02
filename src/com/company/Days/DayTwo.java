package com.company.Days;

import com.company.AdventRunner;
import com.company.Days.One.PartOneExample;
import com.company.Days.Two.PartOne;
import com.company.Days.Two.PartTwo;
import com.company.Days.Two.PartTwoExample;
import com.company.TimedRunner;

public class DayTwo extends AdventRunner {
    public DayTwo() {
        super(2);
    }

    public void run() {
        TimedRunner tr = new TimedRunner();
        tr.run(new PartOne());
        tr.run(new PartOneExample());
        tr.run(new PartTwo());
        tr.run(new PartTwoExample());
    }
}
