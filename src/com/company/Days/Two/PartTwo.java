package com.company.Days.Two;

import com.company.AdventRun;
import java.util.Arrays;

public class PartTwo implements AdventRun<String[]> {
    @Override
    public String getRunName() {
        return "Part 2";
    }

    @Override
    public String[] getInput() {
        return DayTwoInput.get().getInput();
    }

    @Override
    public String run(String[] nodes) {
        Arrays.sort(nodes);
        for (int i = 0; i < nodes.length - 1; i++) {
            String similarCharacters = getSimilarCharacters(nodes[i], nodes[i+1]);
            if (similarCharacters.length() > 0) {
                return similarCharacters;
            }
        }

        return "";
    }

    private String getSimilarCharacters(String first, String second) {
        int differenceCharIndex = -1;

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (differenceCharIndex > -1) {
                    differenceCharIndex = -1;
                    break;
                } else {
                    differenceCharIndex = i;
                }
            }
        }

        if (differenceCharIndex > -1) {
            return first.substring(0, differenceCharIndex) + second.substring(differenceCharIndex + 1);
        }
        return "";
    }
}
