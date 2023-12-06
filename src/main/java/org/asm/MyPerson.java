package org.asm;

import java.util.ArrayList;

public class MyPerson {
    MyBSTree tree;

    public MyPerson() {
        tree = new MyBSTree();
    }

    public void insert(Person person) {
        tree.insert(person);
    }

    public void inOrder() {
        tree.inOrder(tree.root);
    }

    public void bst() {
    }

    public Person search(String id) {
        return tree.search(tree.root, id).info;
    }

    public void delete(String id) {
        tree.delete(tree.root, Integer.parseInt(id));
    }

    public void balance() {
        ArrayList<Person> persons = tree.toList(tree);
        tree.balance(persons);
    }
}
