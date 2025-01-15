package Graphs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DAGShortestPath {
     public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}

class Solution {

    class Pair {
        public int first;
        public int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int[] shortestPath(int V, int E, int[][] edges) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Pair>());
        }

        // Populate the adjacency list with edges
        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        // Step 1: Topological Sort using DFS
        Stack<Integer> stack = new Stack<>();
        int[] vis = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, stack);
            }
        }

        // Step 2: Initialize distances
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        // Step 3: Process nodes in topological order
        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (dist[node] != Integer.MAX_VALUE) {
                for (Pair neighbor : adj.get(node)) {
                    int v = neighbor.first;
                    int wt = neighbor.second;

                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt;
                    }
                }
            }
        }

        // Step 4: Convert unreachable nodes distance to -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    // DFS function for Topological Sorting
    static void dfs(int node, int[] vis, ArrayList<ArrayList<Pair>> adj, Stack<Integer> stack) {
        vis[node] = 1;

        for (Pair neighbor : adj.get(node)) {
            int v = neighbor.first;
            if (vis[v] == 0) {
                dfs(v, vis, adj, stack);
            }
        }

        stack.push(node);  // Add the node to stack once all its neighbors are processed
    }
}
