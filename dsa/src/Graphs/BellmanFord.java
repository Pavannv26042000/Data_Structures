package Graphs;

import java.util.Arrays;

public class BellmanFord {
    

    static int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;
        
        for(int i = 0 ; i < V ; i++){
            for(int[] it : edges){
                int u = it[0];
                int v = it[1];
                int wt = it[2];
                
                if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        
        
         for(int i = 0 ; i < V ; i++){
            for(int[] it : edges){
                int u = it[0];
                int v = it[1];
                int wt = it[2];
                
                if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                    return new int[] {-1};
                }
            }
        }
        
        
        return dist;
    }
}
