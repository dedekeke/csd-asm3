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
        MyPerson person = new MyPerson();

        int choice;

        do {
            showMenu();
            System.out.print("choice = ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("1");
                }
                // Duyệt cây BST theo thứ tự giữa (Inorder)
                case 2 -> System.out.println(2);
                // Duyệt cây BST theo chiều rộng sử dụng thuật toán Breadth-First Traversal
                // (BFT)
                case 3 -> System.out.println(3);
                case 4 -> System.out.println(4);

                case 5 -> System.out.println(5);
                // Cân bằng cây BST
                case 6 -> System.out.println(6);
                // Duyệt đồ thị theo chiều sâu sử dụng thuật toán Depth-First Traversal (DFT)
                // In ra tên tất cả các thành phố (dùng phương pháp duyệt đồ thị theo chiều
                // sâu).
                case 7 -> System.out.println("Product list sorted successfully!");
                // Tìm đường đi ngắn nhất khi đi từ thành phố A đến thành phố F bằng thuật toán
                // Dijkstra theo yêu cầu dưới đây:
                // - in ra đường đi ngắn nhất và độ dài của đường đi ngắn nhất đó từ thành phố A
                // đến thành phố E bằng thuật toán Dijkstra.
                case 8 -> System.out.println("Current number: to binary: ");

                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
