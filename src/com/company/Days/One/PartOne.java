package com.company.Days.One;

import com.company.AdventRun;
import com.company.Node;

public class PartOne implements AdventRun<Node<Integer>> {
    @Override
    public String getRunName() {
        return "Part 1";
    }

    @Override
    public Node<Integer> getInput() {
        return DayOneInput.get().getInput();
    }

    @Override
    public String run(Node<Integer> head) {
        int result = 0;

        do {
            result += head.Value;
        } while ((head = head.Next) != null);

        return Integer.toString(result);
    }
}
