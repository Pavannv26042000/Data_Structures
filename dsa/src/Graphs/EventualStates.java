package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventualStates {
    

    //https://www.geeksforgeeks.org/problems/eventual-safe-states/1

    /**
     * Eventual states using DFS travsersal
     * @param V
     * @param adj
     * @return
     */
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
    List<Integer> ans = new ArrayList<>();
       boolean[] visited = new boolean[V];
        boolean[] pathVis = new boolean[V];
        
        for(int i = 0 ; i<V ; i++){
            if(!visited[i]){
                dfs(i , visited , pathVis , adj , ans);
            }
        }

       Collections.sort(ans);
       return ans;
    }
    
    
    
    public boolean dfs(int i , boolean[] vis , boolean[] pv , List<List<Integer>> adj , List<Integer> ans){
        vis[i] =true;
        pv[i] = true;
        for(int x : adj.get(i)){
            if(!vis[x]){
                if(dfs(x , vis , pv , adj , ans) == true){
                    return true;
                }
            }else if(pv[x]){
                return true;
            }
        }
        pv[i] = false;
        ans.add(i);
        return false;
    }




    // Using Topological sort 

    List<Integer> eventualSafeNodesUsingTopo(int V, List<List<Integer>> adj) {
        List<List<Integer>> adjRev = new ArrayList<>();

        for(int i = 0 ; i < adj.size() ; i++){
                adjRev.add(new ArrayList<>());
        }

        int[] indegree = new int[adj.size() + 1];
        for(int i = 0 ; i < adj.size() ; i++){
            for(Integer x : adj.get(i)){
                
                adjRev.get(x).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> safeNodes  = new ArrayList<>();

        for(int i = 0 ; i < adj.size() ; i++){
            if(indegree[i]== 0){
                queue.add(i);
            }
        }

    while(!queue.isEmpty()){
        int node = queue.remove();
        safeNodes.add(node);

      for(int x : adjRev.get(node)){
          indegree[x]--;
          if(indegree[x] == 0 ){
              queue.add(x);
          }
      }
    }

    Collections.sort(safeNodes);
    return safeNodes;
    }
        
}
