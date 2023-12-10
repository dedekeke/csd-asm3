package org.asm;

import java.util.ArrayList;
import java.util.Scanner;

public class MyPerson {
    MyBSTree tree;

    public MyPerson() {
        tree = new MyBSTree();
    }

    public void insert() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ID: ");
        // if statement to check unique id
        Integer id = scanner.nextInt();
        System.out.println("Name: ");
        String name = scanner.next();
        System.out.println("Birthplace: ");
        String birthplace = scanner.next();
        System.out.println("Date of birth: ");
        String dob = scanner.next();
        Person person = new Person(Integer.toString(id), name, birthplace, dob);
        tree.insert(person);
        System.out.println("New person added;");
        scanner.close();
    }

    public void inOrder() {
        tree.inOrder(tree.root);
    }

    public void bst() {
        tree.bft(tree.root);
    }

    public Person search(String id) {
        Node searchByID = tree.search(tree.root, id);
        if (searchByID == null) {
            System.out.println("Person with ID: " + id + " not found.");
            return null;
        }
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
