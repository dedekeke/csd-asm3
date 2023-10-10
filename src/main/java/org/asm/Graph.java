package org.asm;

import java.io.IOException;

public class Graph {
    static int INF = 9999;
    int[][] a;
    int n;
    char[] b;

    Graph() {}

    void setWeights(String filename) throws IOException {}

    void displayWeights() {}

    void displayStep(int step, boolean[] selected, int[] dist, int[] path, int p, int[] sele, int nSele, boolean[] stopDisplay) {}

    void dijkstra(boolean[] selected, int[] dist, int[] path, int p, int q, boolean[] stopDisplay) {}

    void pathDijkstra(int[] dist, int[] path, int p, int q) {}

    void dijkstra(int p, int q) {}

    void dfs(int k) {}
}
