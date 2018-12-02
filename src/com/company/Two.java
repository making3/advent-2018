package com.company;

import java.util.HashMap;

public class Two extends AdventRunner<Node<String>> {
    public Two() {
        super(2);
    }

    protected String partOne(Node<String> head) {
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

    protected String partTwo(Node<String> head) {
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

    protected Node<String> getInput() {
        Node<String> head = null;
        Node<String> node;

        try {
            Reader reader = getReader();
            String line = reader.nextLine();
            head = new Node(line);
            node = head;
            line = reader.nextLine();

            while (!reader.EOF()) {
                node.Next = new Node(line);
                node = node.Next;
                line = reader.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Exception reading file " + e);
        }

        return head;
    }

    @Override
    protected Node<String> getPartOneExampleInput() {
        Node<String> example = new Node("abcdef");
        example.Next = new Node("bababc");
        example.Next.Next = new Node("abbcde");
        example.Next.Next.Next = new Node("abcccd");
        example.Next.Next.Next.Next = new Node("aabcdd");
        example.Next.Next.Next.Next.Next = new Node("abcdee");
        example.Next.Next.Next.Next.Next.Next = new Node("ababab");
        return example;
    }

    @Override
    protected Node<String> getPartTwoExampleInput() {
        Node<String> example = new Node("abcde");
        example.Next = new Node("fghij");
        example.Next.Next = new Node("klmno");
        example.Next.Next.Next = new Node("pqrst");
        example.Next.Next.Next.Next = new Node("fguij");
        example.Next.Next.Next.Next.Next = new Node("axcye");
        example.Next.Next.Next.Next.Next.Next = new Node("wvxyz");
        return example;
    }
}
