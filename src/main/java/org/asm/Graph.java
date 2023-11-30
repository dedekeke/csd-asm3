package org.asm;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

public class Graph {
    static int INF = 9999;
    int[][] a;
    int n;
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

    void displayWeights() {
    }

    void displayStep(int step, boolean[] selected, int[] dist, int[] path, int p, int[] sele, int nSele,
            boolean[] stopDisplay) {
    }

    void dijkstra(boolean[] selected, int[] dist, int[] path, int p, int q, boolean[] stopDisplay) {
    }

    void pathDijkstra(int[] dist, int[] path, int p, int q) {
    }

    void dijkstra(int p, int q) {
    }

    void dfs(int k) {
    }
}
