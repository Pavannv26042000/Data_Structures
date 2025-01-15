import java.util.LinkedList;
import java.util.Queue;

public class BinaryMaze {
    public int shortestPath(int[][] grid, int[] source, int[] destination) {
        // Edge case: If source or destination is out of bounds or not walkable
        if (grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0) {
            return -1;
        }

        int[][] dist = new int[grid.length][grid[0].length];
        
        // Initialize distances to maximum value
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dist[source[0]][source[1]] = 0;
        
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(source, 0));
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        
        while (!que.isEmpty()) {
            Pair currentPair = que.poll();
            int[] current = currentPair.current;
            int weight = currentPair.weight;

            // Check if we reached the destination
            if (current[0] == destination[0] && current[1] == destination[1]) {
                return weight;
            }
            
            // Explore neighbors
            for (int i = 0; i < 4; i++) {
                int newr = current[0] + dr[i];
                int newc = current[1] + dc[i];
                
                if (newr >= 0 && newc >= 0 && newr < grid.length && newc < grid[0].length 
                    && grid[newr][newc] == 1 && weight + 1 < dist[newr][newc]) {
                    
                    dist[newr][newc] = weight + 1; // Update distance
                    que.add(new Pair(new int[]{newr, newc}, weight + 1)); // Add to queue
                }
            }
        }
        
        return -1; // Destination not reachable
    }
    
    class Pair {
        int[] current;
        int weight;

        Pair(int[] current, int weight) {
            this.current = current;
            this.weight = weight;
        }
    }
}
