package org.asm;

import java.util.Scanner;

public class Main {

    public static void showMenu() {
        System.out.println("\n---------------------------------------------------");
        System.out.println("Choose one of this options:");
        System.out.println("Person Tree:");
        System.out.println("1. Insert a new Person.");
        System.out.println("2. Inorder traversal");
        System.out.println("3. Breadth-First Traversal");
        System.out.println("4. Search by Person ID");
        System.out.println("5. Delete by Person ID");
        System.out.println("6. Balancing Binary Search Tree ");
        System.out.println("7. DFS_Graph");
        System.out.println("8. Dijkstra");
        System.out.println("0. Exit");
        System.out.println("---------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OperationToProduct operationToProduct = new OperationToProduct();

        int choice;

        do {
            showMenu();
            System.out.print("choice = ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("1");
                }
                case 2 -> System.out.println(2);
                case 3 -> System.out.println(3);
                case 4 -> System.out.println(4);

                case 5 -> System.out.println(5);
                case 6 -> System.out.println(6);
                case 7 -> System.out.println("Product list sorted successfully!");

                case 8 -> System.out.println("Current number: to binary: " );

                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
