package com.company.Days.One;

import com.company.Node;

import java.util.HashSet;
import java.util.Set;

public class PartTwo extends PartOne {
    @Override
    public String getRunName() {
        return "Part 2";
    }

    @Override
    public String run(Node<Integer> head) {
        int result = 0;
        Set<Integer> s = new HashSet<>();
        s.add(0);

        Node<Integer> node = head;

        do {
            result += node.Value;
            if (s.contains(result)) {
                break;
            }
            s.add(result);
            if (node.Next == null) {
                node = head;
            } else {
                node = node.Next;
            }
        } while (true);

        return Integer.toString(result);
    }
}
