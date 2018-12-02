package com.company;

import java.util.HashSet;
import java.util.Set;

public class One extends AdventRunner {
    public One() {
        super(1);
    }

    public void run() {
        Node input = getDayOneInput();
        System.out.println("Part 1: " + partOne(input));
        System.out.println("Part 2: " + partTwo(input));
    }

    private int partOne(Node<Integer> head) {
        int result = 0;

        do {
            result += head.Value;
        } while ((head = head.Next) != null);

        return result;
    }

    private int partTwo(Node<Integer> head) {
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

        return result;
    }

    private Node<Integer> getDayOneInput() {
        Node head;
        Node node;

        try {
            Reader reader = getReader();

            String line = reader.nextLine();
            head = new Node(Integer.parseInt(line));
            node = head;
            line = reader.nextLine();

            while (!reader.EOF())  {
                node.Next = new Node(Integer.parseInt(line));
                node = node.Next;
                line = reader.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.toString());
            head = new Node(0);
        }

        return head;
    }
}
