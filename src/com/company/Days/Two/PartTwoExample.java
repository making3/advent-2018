package com.company.Days.Two;

import com.company.Node;

public class PartTwoExample extends PartTwo {
    @Override
    public String getRunName() {
        return super.getRunName() + " Example";
    }

    @Override
    public Node<String> getInput() {
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
