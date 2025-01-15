package Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {


// https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1    
class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}


// User function Template for Java
class Solution {
    // Function to find the shortest distance of all the vertices
    // from the source vertex src.
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
 
        int V = adj.size();
        // to have sorted based on distance
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));

        // to store result
        ArrayList<Integer> dist = new ArrayList<>();
        for(int i = 0; i < V; i++) dist.add(Integer.MAX_VALUE);

        dist.set(src, 0);
        pq.add(new Pair(0, src));


        while(!pq.isEmpty()) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            for(iPair temp : adj.get(node)) {
                int adjNode = temp.first;
                int adjWeight = temp.second;

                if(dis + adjWeight < dist.get(adjNode)) {
                    dist.set(adjNode, dis + adjWeight);
                    pq.add(new Pair(dist.get(adjNode), adjNode));
                }
            }
        }

        return dist;
    }
    

class Pair {
    int distance;
    int node;
    
    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}
}
}
