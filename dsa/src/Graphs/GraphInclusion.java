import java.io.*;
import java.util.*;

public class GraphInclusion {
    static class DSU {
        int[] parent;
        int[] size;

        public DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (size[rootX] < size[rootY]) {
                    int temp = rootX;
                    rootX = rootY;
                    rootY = temp;
                }
                parent[rootY] = rootX; // Union by size
                size[rootX] += size[rootY];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // Number of vertices
        int q = Integer.parseInt(st.nextToken()); // Number of queries

        // Initialize DSU for graphs A and B
        DSU dsuA = new DSU(n);
        DSU dsuB = new DSU(n);

        // Process each query
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char type = st.nextToken().charAt(0); // Query type: 'A' or 'B'
            int x = Integer.parseInt(st.nextToken()); // Vertex x
            int y = Integer.parseInt(st.nextToken()); // Vertex y

            // Update the corresponding graph
            if (type == 'A') {
                dsuA.union(x, y); // Add/remove edge in graph A
            } else {
                dsuB.union(x, y); // Add/remove edge in graph B
            }

            // Count the number of additional edges required
            int additionalEdges = 0;
            Map<Integer, Set<Integer>> componentsB = new HashMap<>();

            // Group vertices in B by their connected components
            for (int v = 1; v <= n; v++) {
                int rootB = dsuB.find(v);
                componentsB.computeIfAbsent(rootB, k -> new HashSet<>()).add(v);
            }

            // Check if each component of B is contained in a single component of A
            for (Set<Integer> componentB : componentsB.values()) {
                int rootA = -1;
                boolean valid = true;
                for (int v : componentB) {
                    int currentRootA = dsuA.find(v);
                    if (rootA == -1) {
                        rootA = currentRootA;
                    } else if (rootA != currentRootA) {
                        valid = false;
                        break;
                    }
                }
                if (!valid) {
                    additionalEdges++;
                }
            }

            // Output the result for this query
            bw.write(additionalEdges + "\n");
        }

        // Flush and close the output
        bw.flush();
        bw.close();
        br.close();
    }
}