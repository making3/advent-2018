package com.company;

import java.util.HashSet;
import java.util.Set;

public class One extends AdventRunner<Node<Integer>> {
    public One() {
        super(1);
    }

    protected String partOne(Node<Integer> head) {
        int result = 0;

        do {
            result += head.Value;
        } while ((head = head.Next) != null);

        return Integer.toString(result);
    }

    protected String partTwo(Node<Integer> head) {
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

    protected Node<Integer> getInput() {
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

    @Override
    protected Node<Integer> getPartOneExampleInput() {
        Node<Integer> example = new Node(1);
        example.Next = new Node(-2);
        example.Next.Next = new Node(3);
        example.Next .Next.Next = new Node(1);
        return example;
    }

    @Override
    protected Node<Integer> getPartTwoExampleInput() {
        return getPartOneExampleInput();
    }
}
