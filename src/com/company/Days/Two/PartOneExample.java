package com.company.Days.Two;

import com.company.Node;

public class PartOneExample extends PartOne {
    @Override
    public String getRunName() {
        return super.getRunName() + " Example";
    }

    @Override
    public Node<String> getInput() {
        Node<String> example = new Node("abcdef");
        example.Next = new Node("bababc");
        example.Next.Next = new Node("abbcde");
        example.Next.Next.Next = new Node("abcccd");
        example.Next.Next.Next.Next = new Node("aabcdd");
        example.Next.Next.Next.Next.Next = new Node("abcdee");
        example.Next.Next.Next.Next.Next.Next = new Node("ababab");
        return example;
    }
}
