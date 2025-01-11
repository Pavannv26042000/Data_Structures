package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class ToplogicalSortDFS {
    public static void main(String[] args) {
        
    }
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        
        int[] vis = new int[adj.size() + 1];
        int v = adj.size();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < v ; i++){
            if(vis[i] == 0){
                dfs(0 , vis , adj , stack);
            }
        }
        
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while (!stack.isEmpty()){
            ans.add(stack.peek());
            stack.pop();
        }
        
        return ans;
    }
    
    static void dfs(int node , int[] vis , ArrayList<ArrayList<Integer>> adj ,  Stack<Integer> stack){
        
        vis[node] = 1;
        
        for(Integer rx : adj.get(node)){
            if(vis[rx] == 0){
               dfs(rx , vis ,adj , stack); 
            }
        }
        
        stack.push(node);
    }
}