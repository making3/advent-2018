package com.company.Days.Two;

import com.company.AdventRun;

import java.util.HashMap;

public class PartOne implements AdventRun<String[]> {
    @Override
    public String getRunName() {
        return "Part 1";
    }

    @Override
    public String[] getInput() {
        return DayTwoInput.get().getInput();
    }

    @Override
    public String run(String[] nodes) {
        int twoCount = 0;
        int threeCount = 0;

        for (int i = 0; i < nodes.length; i++) {
            int innerTwoCount = 0;
            int innerThreeCount = 0;
            HashMap<Character, Integer> m = new HashMap<>();

            for (int k = 0; k < nodes[i].length(); k++) {
                char c = nodes[i].charAt(k);

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
        };

        return Integer.toString(twoCount * threeCount);
    }
}
