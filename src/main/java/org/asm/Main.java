package org.asm;

import java.util.Scanner;

public class Main {
    private static void showMenu() {
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
        System.out.println("9. Display weight matrix (for demo purposes)");
        System.out.println("0. Exit");
        System.out.println("---------------------------------------------------");
    }

    public static void initGraph(Graph graph) {
        String filePath = "src/graph.txt";
        // String filePath = "/Users/bkinm1/Desktop/your
        // map/temp/Funix/as3/csd-asm3/src/graph.txt";
        try {
            graph.setWeights(filePath);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyPerson person = new MyPerson();
        Graph graph = new Graph();
        initGraph(graph);
        person.initSamplePersonList();

        int choice;

        do {
            showMenu();
            System.out.print("choice = ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> person.insert();

                case 2 -> person.inOrder();

                // tree traversal using breadth-first traversal
                case 3 -> person.bst();

                case 4 -> {
                    System.out.println("Search ID: ");
                    String id = scanner.next();
                    Person searchResult = person.search(id);
                    if (searchResult != null) {
                        System.out.println("Person found: " + searchResult.toString());
                    }
                }

                case 5 -> {
                    System.out.println("ID to delete: ");
                    String id = scanner.next();
                    person.delete(id);
                }

                case 6 -> person.balance();
                // TODO investigate
                case 7 -> {
                    System.out.println("Starting point :");
                    int startingPoint = scanner.nextInt();
                    try {
                        graph.dfs(startingPoint);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                case 8 -> {
                    System.out.println("Starting point :");
                    int startingPoint = scanner.nextInt();
                    System.out.println("Endpoint :");
                    int endpoint = scanner.nextInt();
                    try {
                        graph.dijkstra(startingPoint, endpoint);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                // test graph
                case 9 -> {
                    graph.displayWeights();
                }

                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
