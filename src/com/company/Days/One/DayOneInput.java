package com.company.Days.One;

import com.company.Days.DayInput;
import com.company.Node;
import com.company.Reader;

import java.io.IOException;

public class DayOneInput extends DayInput<Node<Integer>> {
    private static DayOneInput dayOneInput = null;
    private DayOneInput() {
        super(1);
    }

    public static DayOneInput get() {
        if (dayOneInput == null) {
            dayOneInput = new DayOneInput();
        }
        return dayOneInput;
    }

    public Node<Integer> loadInput(Reader reader) throws IOException {
        Node head;
        Node node;

        String line = reader.nextLine();
        head = new Node(Integer.parseInt(line));
        node = head;
        line = reader.nextLine();

        while (!reader.EOF())  {
            node.Next = new Node(Integer.parseInt(line));
            node = node.Next;
            line = reader.nextLine();
        }

        return head;
    }

    public Node<Integer> getExampleInput() {
        Node<Integer> example = new Node(1);
        example.Next = new Node(-2);
        example.Next.Next = new Node(3);
        example.Next.Next.Next = new Node(1);
        return example;
    }
}
