package org.asm;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

// TO-DO fix this
public class Graph {
    static int INF = 9999;
    // the matrix preseting data of this graph
    int[][] a;
    // number of vertexes of the graph
    int n;
    // output array contains vertexes presented by character
    char[] b;

    Graph() {
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        b = s1.toCharArray();
    }

    /**
     *
     * @param filename
     * @throws IOException
     */
    void setWeights(String filename) throws IOException {
        int i, j;
        String s = "";
        StringTokenizer t;
        RandomAccessFile f;
        f = new RandomAccessFile(filename, "r");
        s = f.readLine();
        n = Integer.parseInt(s.trim());

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
        f.close();
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

    void displayStep(
            int step,
            boolean[] selected,
            int[] dist,
            int[] path,
            int p,
            int[] sele,
            int nSele,
            boolean[] stopDisplay) {
        System.out.println("Step " + step);
        for (int i = 0; i < n; i++) {
            if (!selected[i]) {
                System.out.printf("%c(%d) ", b[i], dist[i]);
            }
        }
        System.out.println();
        System.out.print("Path: ");
        for (int i = 0; i < nSele; i++) {
            System.out.print(b[sele[i]]);
            if (i != nSele - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println(b[p]);
    }

    void dijkstra(boolean[] selected, int[] dist, int[] path, int p, int q,
            boolean[] stopDisplay) {
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
    }

    // your code here
    void dijkstra(int p, int q) {
        boolean[] selected = new boolean[n];
        int[] dist = new int[n];
        int[] path = new int[n];

        for (int i = 0; i < n; i++) {
            selected[i] = false;
            dist[i] = INF;
            path[i] = -1;
        }

        dist[p] = 0;

        for (int count = 0; count < n - 1; count++) {
            int u = -1;
            int minDist = INF;

            for (int v = 0; v < n; v++) {
                if (!selected[v] && dist[v] < minDist) {
                    u = v;
                    minDist = dist[v];
                }
            }

            if (u == -1) {
                break; // No more vertices to explore or all remaining vertices are unreachable
            }

            selected[u] = true;

            for (int v = 0; v < n; v++) {
                if (!selected[v] && a[u][v] != INF && dist[u] + a[u][v] < dist[v]) {
                    dist[v] = dist[u] + a[u][v];
                    path[v] = u;
                }
            }
        }

        // Displaying the shortest path and distance from vertex p to vertex q
        if (dist[q] == INF) {
            System.out.println("No path from " + b[p] + " to " + b[q]);
            return;
        }

        System.out.println("The length of shortest path from " + b[p] + " to " + b[q] + " is " + dist[q]);

        System.out.print("Path: ");
        int u = q;
        while (u != p) {
            System.out.print(b[u] + " <- ");
            u = path[u];
        }
        System.out.println(b[p]);
    }

    void pathDijkstra(int[] dist, int[] path, int p, int q) {
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
    }

    // k is starting point
    void dfs(int k) {
        boolean[] visited = new boolean[n];
        MyStack<Integer> stack = new MyStack<>();
        stack.push(k);

        while (!stack.isEmpty()) {
            var current = stack.pop();
            if (!visited[current]) {
                visited[current] = true;
                System.out.println("Visited node: " + b[current]); // Or perform any other operation

                for (int i = 0; i < n; i++) {
                    if (a[current][i] != INF && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
    }

    // main function of Graph
    // Graph creation

}
