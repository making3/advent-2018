package com.company.Days.Five;

public class PartTwoExample extends PartTwo {
    @Override
    public String getRunName() {
        return super.getRunName() + " Example";
    }

    @Override
    public String getInput() {
        return new PartOneExample().getInput();
    }
}
