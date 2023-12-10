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
    }

    /**
     *
     * @param filename
     * @throws IOException
     */
    void setWeights(String filename) throws IOException {
        int i, j;
        String s = "", s1 = "";
        StringTokenizer t;
        RandomAccessFile f;
        f = new RandomAccessFile(filename, "r");
        s = f.readLine();
        n = Integer.parseInt(s.trim());
        f.close();
    }

    /**
     * Printing the matrix of this graph
     */
    void displayWeights() {
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
            System.out.print(b[sele[i]] + " -> ");
        }
        System.out.println(b[p]);
    }

    void dijkstra(boolean[] selected, int[] dist, int[] path, int p, int q, boolean[] stopDisplay) {
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
        selected[p] = true;
        int u = p;
        while (u != q) {
            u = path[u];
        }
    }

    void dfs(int k) {
        boolean[] selected = new boolean[n];
        int[] dist = new int[n];
        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            selected[i] = false;
            dist[i] = INF;
            path[i] = -1;
        }
        dist[k] = 0;
        selected[k] = true;
        int u = k;
        while (u != -1) {
            u = path[u];
        }
    }
}
