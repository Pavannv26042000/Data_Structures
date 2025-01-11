package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ToplogicalSortBFS {
    
/**
 * Detect cycle in Directed Graph using BFS algorithm ( Khan's Algorithm)
 * 
 * @param adj
 * @return
 */
// Function to return list containing vertices in Topological order.
    static boolean topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        

        int[] indegree = {};
        for(int i = 0 ; i<adj.size() ; i++){
            for(Integer x : adj.get(i)){
                indegree[x]++;
            }
        }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < adj.size(); i++) {
        if(indegree[i] ==0){
            queue.add(i);
        }
    }

    int count = 0 ;
    while(!queue.isEmpty()){
        int node = queue.peek();
        queue.remove();
        count++;   
        for(Integer x : adj.get(node)){
            indegree[x]--;
            if(indegree[x] == 0) queue.add(x);
        }
    }

     if (count == adj.size()) return true;
       return false;
    }
    

}
