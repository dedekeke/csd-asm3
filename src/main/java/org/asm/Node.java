package org.asm;

public class Node {
    public Person info;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(Person info) {
        this.info = info;
        left = right = null;
    }

}


