package com.company.Days.Five;

import java.util.HashMap;
import java.util.Stack;

public class PartTwo extends PartOne {
    @Override
    public String getRunName() {
        return "Part 2";
    }

    @Override
    public String run(String s) {
        int shortest = Integer.MAX_VALUE;

        for (int i = 0; i < 27; i++) {
            int result = run(s, i);
            if (result < shortest) {
                shortest = result;
            }
        }

        return Integer.toString(shortest);
    }

    private int run(String s, int charIndex) {
        Stack<Character> previous = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == charIndex + 65 || c == charIndex + 97) {
                continue;
            }

            if (previous.isEmpty() || !isReaction(previous.peek(), c)) {
                previous.push(c);
            } else {
                previous.pop();
            }
        }

        return previous.size();
    }
}
