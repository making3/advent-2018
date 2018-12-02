package com.company;

import java.util.HashMap;

public class Two extends AdventRunner {
    private Node<String> _exampleHead;
    private Node<String> _exampleHeadPart2;

    public Two() {
        super(2);
        _exampleHead = new Node("abcdef");
        _exampleHead.Next = new Node("bababc");
        _exampleHead.Next.Next = new Node("abbcde");
        _exampleHead.Next.Next.Next = new Node("abcccd");
        _exampleHead.Next.Next.Next.Next = new Node("aabcdd");
        _exampleHead.Next.Next.Next.Next.Next = new Node("abcdee");
        _exampleHead.Next.Next.Next.Next.Next.Next = new Node("ababab");

        _exampleHeadPart2 = new Node("abcde");
        _exampleHeadPart2.Next = new Node("fghij");
        _exampleHeadPart2.Next.Next = new Node("klmno");
        _exampleHeadPart2.Next.Next.Next = new Node("pqrst");
        _exampleHeadPart2.Next.Next.Next.Next = new Node("fguij");
        _exampleHeadPart2.Next.Next.Next.Next.Next = new Node("axcye");
        _exampleHeadPart2.Next.Next.Next.Next.Next.Next = new Node("wvxyz");
    }

    public void run() {
        Node input = getFileInput();
        System.out.println("Part 1 Example: " + partOne(_exampleHead));
        System.out.println("Part 1 - " + partOne(input));
        System.out.println("Part 2 - Example - " + partTwo(_exampleHeadPart2));
        System.out.println("Part 2 - " + partTwo(input));
    }

    private int partOne(Node<String> head) {
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

        return twoCount * threeCount;
    }

    private String partTwo(Node<String> head) {
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
                    return node.Value.substring(0, differenceCharIndex) + node.Value.substring(differenceCharIndex+1);
                }
            } while ((innerNode = innerNode.Next) != null);

        } while ((node = node.Next) != null);

        return "";
    }

    private Node getFileInput() {
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

}
