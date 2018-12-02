package com.company.Days.One;

import com.company.Node;

public class PartOneExample extends PartOne {
    @Override
    public String getRunName() {
        return super.getRunName() + " Example";
    }

    @Override
    public Node<Integer> getInput() {
        return DayOneInput.get().getExampleInput();
    }
}
