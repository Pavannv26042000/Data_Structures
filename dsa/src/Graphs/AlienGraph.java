package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienGraph {
    public String findOrder(String[] dict, int k) {
    List<List<Integer>> adj = new ArrayList<>();
    
    // Initialize adjacency list
    for (int i = 0; i < k; i++) {
        adj.add(new ArrayList<>());
    }
    
    // Build graph
    for (int i = 0; i < dict.length - 1; i++) {
        String s1 = dict[i];
        String s2 = dict[i + 1];
        
        int len = Math.min(s1.length(), s2.length());
        
        for (int j = 0; j < len; j++) {
            if (s1.charAt(j) != s2.charAt(j)) {
                adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                break;
            }
        }
    }

    // Calculate indegrees
    int[] indegree = new int[k];
    for (int i = 0; i < k; i++) {
        for (Integer neighbor : adj.get(i)) {
            indegree[neighbor]++;
        }
    }

    // Topological sort using BFS (Kahn's Algorithm)
    Queue<Integer> queue = new LinkedList<>();
    List<Integer> topo = new ArrayList<>();
    for (int i = 0; i < k; i++) {
        if (indegree[i] == 0) {
            queue.add(i);
        }
    }
    
    while (!queue.isEmpty()) {
        int node = queue.poll();
        topo.add(node);
        for (Integer neighbor : adj.get(node)) {
            indegree[neighbor]--;
            if (indegree[neighbor] == 0) {
                queue.add(neighbor);
            }
        }
    }
    
    // If the topological sort does not include all nodes, there is a cycle (no valid order)
    if (topo.size() != k) {
        return "";
    }
    
    // Build the result string
    StringBuilder ans = new StringBuilder();
    for (int c : topo) {
        ans.append((char) (c + 'a'));
    }
    
    return ans.toString();
}
  
}
