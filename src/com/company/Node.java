package com.company;

public class Node<TValue> {
    public TValue Value;
    public Node Next;

    public Node(TValue value) {
        Value = value;
    }

//    public int GetValue() {
//        return _value;
//    }
//
//    public void SetValue(String value) {
//        _value = Integer.parseInt(value);
//    }
}
