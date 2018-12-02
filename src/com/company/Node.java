package com.company;

public class Node<TValue> {
    public TValue Value;
    public Node Next;

    public Node(TValue value) {
        Value = value;
    }
}
