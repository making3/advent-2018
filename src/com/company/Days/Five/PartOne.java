package com.company.Days.Five;

import com.company.AdventRun;

import java.util.Stack;

public class PartOne implements AdventRun<String> {
    @Override
    public String getRunName() {
        return "Part 1";
    }

    @Override
    public String getInput() {
        return DayFiveInput.get().getInput();
    }

    @Override
    public String run(String s) {
        Stack<Character> previous = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (previous.isEmpty() || !isReaction(previous.peek(), c)) {
                previous.push(c);
            } else {
                previous.pop();
            }
        }

        return Integer.toString(previous.size());
    }

    protected boolean isReaction(char first, char second) {
        int diff = 32;
        return (first > second && first - diff == second) ||
               (second > first && second - diff == first);
    }
}
