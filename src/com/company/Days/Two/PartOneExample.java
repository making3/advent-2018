package com.company.Days.Two;

public class PartOneExample extends PartOne {
    @Override
    public String getRunName() {
        return super.getRunName() + " Example";
    }

    @Override
    public String[] getInput() {
        return new String[] {
            "abcdef",
            "bababc",
            "abbcde",
            "abcccd",
            "aabcdd",
            "abcdee",
            "ababab"
        };
    }
}
