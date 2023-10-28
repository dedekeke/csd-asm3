package org.asm;

import java.util.ArrayList;
import java.util.Objects;

public class MyBSTree {
    public Node root;

    public MyBSTree() {
        root = null;
    }

    void clear() {}

    public boolean isEmpty() { return true; }

    public void inOrder(Node node) {
        if (node == null)
            return;

        // First recur on left child
        inOrder(node.getLeft());

        // Then print the data of node
        System.out.print(node.getInfo() + " ");

        // Now recur on right child
        inOrder(node.getRight());
    }

    public int count(Node node) { return 1; }

    public void bft(Node node) {}

    public void insert(Person person) {
        if (root == null) root = new Node(person);
        else if (Integer.parseInt(person.ID()) < Integer.parseInt(root.getInfo().ID())) {
            root.setLeft(new Node(person));
        } else if (Integer.parseInt(person.ID()) > Integer.parseInt(root.getInfo().ID())) {
            root.setRight(new Node(person));
        }
    }

    void inOrder(ArrayList<Person> list, Node node) {}

    private void balance(ArrayList<Person> list, int first, int last) {}

    public void balance() {}

    public Node search(Node root, String id) {
        /* Base Cases: root is null or key is present at root */
        if (root == null || Objects.equals(root.getInfo().ID(), id))
            return root;

        /* Key is greater than root's key */
        if (Integer.parseInt(root.getLeft().getInfo().ID()) < Integer.parseInt(id))
            return search(root.getRight(), id);

        /* Key is smaller than root's key */
        return search(root.getLeft(), id);
    }

    public void delete(String id) {
        int intID = Integer.parseInt(id);
        if (Integer.parseInt(root.getInfo().ID()) > intID) {
            delete(root.getLeft().getInfo().ID());
        } else if (Integer.parseInt(root.getInfo().ID()) < intID) {
            delete(root.getRight().getInfo().ID());
        }
        /* continue */
    }
}
