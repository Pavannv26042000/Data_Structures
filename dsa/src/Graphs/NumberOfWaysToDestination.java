package Graphs;

import java.util.*;

class NumberOFWays {
    public int countWays(int n, int[][] flights, int src, int dst, int k) {
        // Adjacency list to represent the graph
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill the adjacency list with flight information
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        // DP table to store the number of ways to reach each node with at most k stops
        int[][] dp = new int[n][k + 1];

        // Initially, there is 1 way to be at the source with 0 stops
        dp[src][0] = 1;

        // BFS-like approach, exploring up to k stops
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0}); // {node, stop}

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int stops = current[1];

            // If we have already used k stops, we don't need to explore further
            if (stops >= k) continue;

            // Explore all neighbors
            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                // Add the number of ways to reach the next node
                if (dp[nextNode][stops + 1] == 0) {
                    queue.offer(new int[]{nextNode, stops + 1});
                }
                dp[nextNode][stops + 1] += dp[node][stops];
            }
        }

        // Sum all the ways to reach the destination with at most k stops
        int result = 0;
        for (int i = 0; i <= k; i++) {
            result += dp[dst][i];
        }

        return result;
    }
}

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt(); // number of cities
            int e = sc.nextInt(); // number of flights
            int[][] flights = new int[e][3];

            // Read flights information
            for (int i = 0; i < e; i++) {
                flights[i][0] = sc.nextInt();
                flights[i][1] = sc.nextInt();
                flights[i][2] = sc.nextInt();
            }

            int src = sc.nextInt();
            int dst = sc.nextInt();
            int k = sc.nextInt();


            NumberOFWays obj = new NumberOFWays();
            int result = obj.countWays(n, flights, src, dst, k);
            System.out.println(result);
        }
    }
}

