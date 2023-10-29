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
        inOrder(node.left);

        // Then print the data of node
        System.out.print(node.info + " ");

        // Now recur on right child
        inOrder(node.right);
    }

    public int count(Node node) { return 1; }

    public void bft(Node node) {}

    public void insert(Person person) {
        if (root == null) root = new Node(person);
        else if (Integer.parseInt(person.ID()) < Integer.parseInt(root.info.ID())) {
            root.left = new Node(person);
        } else if (Integer.parseInt(person.ID()) > Integer.parseInt(root.info.ID())) {
            root.right = new Node(person);
        }
    }

    void inOrder(ArrayList<Person> list, Node node) {}

    private void balance(ArrayList<Person> list, int first, int last) {}

    public void balance() {}

    public Node search(Node root, String id) {
        /* Base Cases: root is null or key is present at root */
        if (root == null || Objects.equals(root.info.ID(), id))
            return root;

        /* Key is greater than root's key */
        if (Integer.parseInt(root.left.info.ID()) < Integer.parseInt(id))
            return search(root.right, id);

        /* Key is smaller than root's key */
        return search(root.left, id);
    }

    public void delete(String id) {
        int intID = Integer.parseInt(id);
        if (Integer.parseInt(root.info.ID()) > intID) {
            delete(root.left.info.ID());
        } else if (Integer.parseInt(root.info.ID()) < intID) {
            delete(root.right.info.ID());
        }
        if (root.left == null) {
            Node temp = root.right;

        }
    }
}
