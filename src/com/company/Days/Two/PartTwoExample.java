package com.company.Days.Two;

public class PartTwoExample extends PartTwo {
    @Override
    public String getRunName() {
        return super.getRunName() + " Example";
    }

    @Override
    public String[] getInput() {
        return new String[]{
            "abcde",
            "fghij",
            "klmno",
            "pqrst",
            "fguij",
            "axcye",
            "wvxyz"
        };
    }
}
