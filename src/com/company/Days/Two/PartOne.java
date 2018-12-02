package com.company.Days.Two;

import com.company.AdventRun;
import com.company.Node;

import java.util.HashMap;

public class PartOne implements AdventRun<Node<String>> {
    @Override
    public String getRunName() {
        return "Part 1";
    }

    @Override
    public Node<String> getInput() {
        return DayTwoInput.get().getInput();
    }

    @Override
    public String run(Node<String> head) {
        int twoCount = 0;
        int threeCount = 0;

        Node<String> node = head;

        do {
            int innerTwoCount = 0;
            int innerThreeCount = 0;
            HashMap<Character, Integer> m = new HashMap<>();

            for (int i = 0; i < node.Value.length(); i++) {
                char c = node.Value.charAt(i);

                if (m.containsKey(c)) {
                    int newCount = m.get(c) + 1;
                    if (newCount == 2) {
                        innerTwoCount++;
                    } else if (newCount == 3) {
                        innerTwoCount--;
                        innerThreeCount++;
                    } else if (newCount == 4) {
                        innerThreeCount--;
                    }
                    m.put(c, newCount);
                } else {
                    m.put(c, 1);
                }
            }

            if (innerThreeCount > 0) {
                threeCount++;
            }
            if (innerTwoCount > 0) {
                twoCount++;
            }
        } while ((node = node.Next) != null);

        return Integer.toString(twoCount * threeCount);
    }
}
