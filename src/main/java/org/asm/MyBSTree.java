package org.asm;

import java.util.ArrayList;
import java.util.Objects;

public class MyBSTree {
    public Node root;

    public MyBSTree() {
        root = null;
    }

    void clear(Node root) {
        root = clearTree(root);
    }

    private Node clearTree(Node root) {
        if (root != null) {
            root.left = clearTree(root.left);
            root.right = clearTree(root.right);
            root = null;
        }
        return null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void inOrder(Node node) {
        if (node == null)
            return;
        // First recur on left child
        inOrder(node.left);
        // Then print the data of node
        System.out.println(node.info + " ");
        // Now recur on right child
        inOrder(node.right);
    }

    private void inOrder(ArrayList<Person> list, Node node) {
        if (node == null) {
            return;
        }
        inOrder(list, node.left);
        list.add(node.info);
        inOrder(list, node.right);
    }

    // Breadth first traversal
    public void bft(Node node) {
        if (node == null) {
            return;
        }

        MyQueue queue = new MyQueue();
        queue.enqueue(node);

        while (!queue.isEmpty()) {
            Node currentNode = (Node) queue.dequeue();

            System.out.println(currentNode.info + " ");
            // enqueue left child
            if (currentNode.left != null) {
                queue.enqueue(currentNode.left);
            }
            // enqueue right child
            if (currentNode.right != null) {
                queue.enqueue(currentNode.right);
            }
        }
    }

    public void insert(Person person) {
        if (root == null) {
            root = new Node(person);
            return;
        }

        Node f, p;
        p = root;
        f = null;

        while (p != null) {
            if (p.info.equals(person)) {
                System.out.println("The key " + person.ID() + " already exists, no insertion");
                return;
            }

            f = p;

            if (Integer.parseInt(person.ID()) < Integer.parseInt(p.info.ID())) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        if (Integer.parseInt(person.ID()) < Integer.parseInt(f.info.ID())) {
            f.left = new Node(person);
        } else {
            f.right = new Node(person);
        }
    }

    /**
     * First, calling the inOrder(ArrayList<Person> list, Node node) to
     * copy all items from the tree to array
     * inOrder(ArrayList<Person> list, Node node);
     * Second, calling the balance(ArrayList<Person> list, int first, int last)
     * to balance the tree
     * balance(ArrayList<Person> list, int first, int last)
     * 
     * @param list
     * @param first
     * @param last
     * @return
     */

    private Node balance(ArrayList<Person> list, int first, int last) {
        if (first > last)
            return null;
        int middle = (first + last) / 2;
        Node current = new Node(list.get(middle));
        current.left = balance(list, first, middle - 1);
        current.right = balance(list, middle + 1, last);
        return current;
    }

    public void balance() {
        // store nodes of given BST in sorted order
        ArrayList<Person> list = new ArrayList<>();
        inOrder(list, root);
        balance(list, 0, list.size() - 1);
    }

    public Node search(Node root, String id) {
        if (root == null)
            return null;

        int idInt = Integer.parseInt(id);
        int rootIdInt = Integer.parseInt(root.info.ID());

        /* Base Cases: root is null or key is present at root */
        if (rootIdInt == idInt)
            return root;
        /* Key is greater than root's key */
        else if (rootIdInt < idInt)
            return search(root.right, id);
        /* Key is smaller than root's key */
        else
            return search(root.left, id);

    }

    public Node delete(Node root, int id) {
        if (root == null) {
            return root;
        }

        // If the key to be deleted is smaller than the root's key,
        // then it lies in the left subtree
        if (id < Integer.parseInt(root.info.ID())) {
            root.left = delete(root.left, id);
        } else if (id > Integer.parseInt(root.info.ID())) {
            // If the key to be deleted is greater than the root's key,
            // then it lies in the right subtree
            root.right = delete(root.right, id);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                System.out.println("Deleted node with ID: " + root.info.ID());
                return root.right;
            } else if (root.right == null) {
                System.out.println("Deleted node with ID: " + root.info.ID());
                return root.left;
            }

            // Node with two children: Get the inorder successor
            // (smallest in the right subtree)
            Node successor = findSuccessor(root.right);

            // Copy the inorder successor's content to this node
            root.info = successor.info;

            // Delete the inorder successor
            root.right = delete(root.right, Integer.parseInt(successor.info.ID()));
        }
        return root;
    }

    private Node findSuccessor(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // toList method
    ArrayList<Person> persons = new ArrayList<Person>();

    public ArrayList<Person> toList(MyBSTree tree) {
        personList(tree.root);
        return persons;
    }

    private void personList(Node node) {
        if (node != null) {
            personList(root.left);
            persons.add(node.info);
            personList(root.right);
        }
    }
}
