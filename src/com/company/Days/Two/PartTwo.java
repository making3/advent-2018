package com.company.Days.Two;

import com.company.AdventRun;
import com.company.Node;

public class PartTwo implements AdventRun<Node<String>> {
    @Override
    public String getRunName() {
        return "Part 2";
    }

    @Override
    public Node<String> getInput() {
        return DayTwoInput.get().getInput();
    }

    @Override
    public String run(Node<String> head) {
        Node<String> node = head;
        do {
            Node<String> innerNode = node.Next;
            do {
                int differenceCharIndex = -1;

                for (int i = 0; i < node.Value.length(); i++) {
                    if (node.Value.charAt(i) != innerNode.Value.charAt(i)) {
                        if (differenceCharIndex > -1) {
                            differenceCharIndex = -1;
                            break;
                        } else {
                            differenceCharIndex = i;
                        }
                    }
                }

                if (differenceCharIndex > -1) {
                    return node.Value.substring(0, differenceCharIndex) + node.Value.substring(differenceCharIndex + 1);
                }
            } while ((innerNode = innerNode.Next) != null);

        } while ((node = node.Next) != null);

        return "";
    }
}
