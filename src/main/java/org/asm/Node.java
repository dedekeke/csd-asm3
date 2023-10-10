package org.asm;

public class Node {
    private Person info;
    private Node left;
    private Node right;

    public Node() {
    }

    public Node(Person info) {
        this.info = info;
    }

    public Person getInfo() {
        return info;
    }

    public void setInfo(Person info) {
        this.info = info;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}


