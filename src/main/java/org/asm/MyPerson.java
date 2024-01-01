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
        String id = "";

        while (true) {
            System.out.println("ID: ");
            id = scanner.nextLine();
            if (id.isEmpty() || id.equals("") || id.equals(" ")) {
                System.out.println("Invalid ID");
            } else if (!isNumeric(id))
                System.out.println("ID must be a number");
            else
                break;
        }

        String name = getInputString(scanner, "Name");
        String birthplace = getInputString(scanner, "Birthplace");
        String dob = getInputString(scanner, "Date of birth");

        if (name.isEmpty() || birthplace.isEmpty() || dob.isEmpty()) {
            System.out.println("Fields cannot be empty.");
            scanner.close();
            return;
        }

        Person person = new Person(id, name, birthplace, dob);
        tree.insert(person);
        System.out.println("New person added;");
    }

    private String getInputString(Scanner scanner, String fieldName) {
        System.out.println(fieldName + ": ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty() || input.equals("") || input.equals(" ")) {
            System.out.println(fieldName + " cannot be empty.");
        }
        return input;
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
        return searchByID.info;
    }

    public void delete(String id) {
        tree.delete(tree.root, Integer.parseInt(id));
    }

    public void balance() {
        tree.balance();
    }

    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
