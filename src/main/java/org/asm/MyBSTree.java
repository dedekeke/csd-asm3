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
        return true;
    }

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

    public int count(Node node) {
        return 1;
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

            System.out.print(currentNode.info + " ");
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

    // First, calling the inOrder(ArrayList<Person> list, Node node) to

    // copy all items from the tree to array

    // inOrder(ArrayList<Person> list, Node node);

    //

    // Second, calling the balance(ArrayList<Person> list, int first, int last)

    // to balance the tree

    // balance(ArrayList<Person> list, int first, int last)

    private void balance(ArrayList<Person> list, int first, int last) {
        if (first <= last) {
            int middle = (first + last) / 2;
            insert(list.get(middle));
            balance(list, first, middle - 1);
            balance(list, middle + 1, last);
        }
    }

    public void balance(ArrayList<Person> list) {
        balance(list, 0, list.size() - 1);
    }

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

    public Node delete(Node root, int id) {
        // Base case
        if (root == null)
            return root;

        // Recursive calls for ancestors of
        // node to be deleted
        if (Integer.parseInt(root.info.ID()) > id) {
            root.left = delete(root.left, id);
            return root;
        } else if (Integer.parseInt(root.info.ID()) < id) {
            root.right = delete(root.right, id);
            return root;
        }

        // We reach here when root is the node
        // to be deleted.

        // If one of the children is empty
        if (root.left == null) {
            Node temp = root.right;
            return temp;
        } else if (root.right == null) {
            Node temp = root.left;
            return temp;
        }

        // If both children exist
        else {

            Node succParent = root;

            // Find successor
            Node succ = root.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }

            // Delete successor. Since successor
            // is always left child of its parent
            // we can safely make successor's right
            // right child as left of its parent.
            // If there is no succ, then assign
            // succ.right to succParent.right
            if (succParent != root)
                succParent.left = succ.right;
            else
                succParent.right = succ.right;

            // Copy Successor Data to root
            root.info = succ.info;

            // Delete Successor and return root
            return root;
        }
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
