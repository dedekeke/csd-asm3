package org.asm;

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

        Person person = Person.addPerson(id, name, birthplace, dob);
        if (person != null) {
            tree.insert(person);
            System.out.println("New person added;");
        } else {
            System.out.println("Person ID is already existed");
        }
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

    public void initSamplePersonList() {
        //       4
        //      / \
        //     3   5
        //    /     \
        //   2       6
        //  /         \
        // 1           7
        Person[] persons = {
                Person.addPerson("4", "John Wick", "Black hole", "0209"),
                Person.addPerson("3", "Alice", "Wonderland", "0503"),
                Person.addPerson("2", "Bob", "Atlantis", "1221"),
                Person.addPerson("1", "Charlie", "Olympus", "0101"),
                Person.addPerson("5", "Eva", "Gotham", "1122"),
                Person.addPerson("6", "Frank", "Rivendell", "0714"),
                Person.addPerson("7", "Grace", "Valhalla", "0408")
        };

        //        4
        //       /
        //      3
        //     /
        //    2
        //   /
        //  1
        // Person[] persons = {
        // Person.addPerson("4", "John Wick", "Black hole", "0209"),
        // Person.addPerson("3", "Alice", "Wonderland", "0503"),
        // Person.addPerson("2", "Bob", "Atlantis", "1221"),
        // Person.addPerson("1", "Charlie", "Olympus", "0101")
        // };
        for (Person p : persons) {
            tree.insert(p);
        }
    }
}
