package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UnDirectedGraph {

        //https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1

        /***
         * Shortest Distance in Undirected acyclic graph 
         * @param adj
         * @param src
         * @return
         */
       public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int n = adj.size() ;
        
        int dist[] = new int[n];
        
        for(int i = 0 ; i<n ; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        dist[src] = 0 ;
        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.remove();
            if(dist[node] != Integer.MAX_VALUE){
                  for(Integer x : adj.get(node)){
                    if (dist[node] + 1 < dist[x]) {
                        dist[x] = dist[node] + 1;
                        queue.add(x);
                    }
                }  
            }
            
        }
        
        for(int i = 0 ; i < dist.length ; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        
        return dist;
        
        
    }
    
}
