package com.company.Days.Two;

import com.company.Days.DayInput;
import com.company.Node;
import com.company.Reader;

import java.io.IOException;

public class DayTwoInput extends DayInput<Node<String>> {
    private static DayTwoInput dayTwoInput;

    private DayTwoInput() {
        super(2);
    }

    public static DayTwoInput get() {
        if (dayTwoInput == null) {
            dayTwoInput = new DayTwoInput();
        }
        return dayTwoInput;
    }

    @Override
    protected Node<String> loadInput(Reader reader) throws IOException {
        Node<String> head;
        Node<String> node;

        String line = reader.nextLine();
        head = new Node(line);
        node = head;
        line = reader.nextLine();

        while (!reader.EOF()) {
            node.Next = new Node(line);
            node = node.Next;
            line = reader.nextLine();
        }

        return head;
    }
}
