package org.asm;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

public class Graph {
    static int INF = 9999;
    // the matrix presenting data of this graph
    int[][] a;
    // number of vertexes of the graph
    int n;
    // output array contains vertexes presented by character
    char[] b;
    // current
    String passed = "";
    String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    Graph() {
        b = s1.toCharArray();
    }

    /**
     * @param filename
     */
    void setWeights(String filename) throws IOException {
        int i, j;
        String s;
        StringTokenizer t;
        RandomAccessFile f;
        f = new RandomAccessFile(filename, "r");
        s = f.readLine();
        n = Integer.parseInt(s.trim()); // 25 or 7

        // Initialize the matrix
        a = new int[n][n];

        // Read the rest of the file and construct the graph matrix
        for (i = 0; i < n; i++) {
            s = f.readLine();
            t = new StringTokenizer(s);
            for (j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(t.nextToken());
            }
        }
    }

    /**
     * Printing the matrix of this graph
     */
    void displayWeights() {
        if (a == null || a.length == 0 || a[0].length == 0) {
            System.out.println("No data to display.");
            return;
        }
        System.out.println("Weight Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(a[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    private void displayStep(int[] dist, int temp, boolean[] selected) {
        passed += s1.charAt(temp);
        System.out.println(passed);
        for(int i = 0; i < n; i++) {
            if (!selected[i]) {
                if (dist[i] != INF)
                    System.out.println("Stored total time to " + s1.charAt(i) + " is: " + dist[i]);
            }
        }
        System.out.println();
    }

    private int minDistance(int[] dist, boolean[] selected) {
        // Initialize min value
        int min = INF, min_index = -1;

        for (int v = 0; v < n; v++)
            if (!selected[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    public void dijkstra(int start, int end) {
        boolean[] selected = new boolean[n];
        int[] dist = new int[n];
        int[] path = new int[n];

        for (int i = 0; i < n; i++) {
            selected[i] = false;
            // set all the distance to be INF
            dist[i] = INF;
        }
        // except for the starting point cause the dist from starting point to the
        // starting point is 0
        dist[start] = 0;
        displayWeights();
        for (int count = 0; count < n - 1; count++) {
            int u = minDistance(dist, selected);
            // Mark the picked vertex as chose
            selected[u] = true;
            // break if reach destination
            if (u == end) break;

            for (int v = 0; v < n; v++) {
                // Update dist[v] only if is not in selected,
                // there is an edge from u to v, and total
                // weight of path from src to v through u is
                // smaller than current value of dist[v]
                if (!selected[v] && a[u][v] != 0 && dist[u] != INF && dist[u] + a[u][v] < dist[v]) {
                    dist[v] = dist[u] + a[u][v];
                    path[v] = u;
                }
            }
            System.out.print(count + ": ");
            displayStep(dist, u, selected);
        }
        displayPath(dist, path, start, end);
    }

    // path tracking
    void displayPath(int[] dist, int[] path, int p, int q) {
        if (dist[q] == INF) {
            System.out.println("No path from " + b[p] + " to " + b[q]);
            return;
        }
        System.out.print("Path: " + b[q]);
        int u = q;
        while (u != p) {
            u = path[u];
            System.out.print(" <- " + b[u]);
        }
        System.out.println();
        System.out.println("The length of shortest path from " + b[p] + " to " + b[q] + " is " + dist[q]);
    }

    void dfs(int k) {
        boolean[] visited = new boolean[n];
        MyStack<Integer> stack = new MyStack<>();
        stack.push(k);
        StringBuilder result = new StringBuilder(); // To store the visited nodes

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                visited[current] = true;
                result.append(b[current]);
                System.out.println("Visited node: " + b[current]);

                for (int i = 0; i < n; i++) {
                    // check if there exists an edge between current and node i
                    if (a[current][i] != 0 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
        // Print the sequence of visited nodes in the required format
        System.out.println("DFS_Graph: " + result);
    }
}
