package org.asm;

public class MyPerson {
    MyBSTree tree;

    public MyPerson() {
        tree = new MyBSTree();
    }

    public void insert(Person person) {
        tree.insert(person);
    }

    public void inOrder() {}

    public void bst() {}

    public Person search(int id) {
        return tree.search(tree.root, String.valueOf(id)).info;
    }

    public void delete() {}

    public void balance() {}
}
