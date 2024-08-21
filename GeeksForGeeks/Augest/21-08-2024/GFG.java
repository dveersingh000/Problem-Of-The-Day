class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill the adjacency list with edges
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Distance array initialized to -1
        int[] distance = new int[n];
        Arrays.fill(distance, -1);

        // BFS initialization
        Queue<Integer> queue = new LinkedList<>();
        distance[src] = 0; // Distance to the source is 0
        queue.add(src);

        // BFS loop
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int dist = distance[node];

            // Visit all adjacent nodes
            for (int neighbor : adj.get(node)) {
                if (distance[neighbor] == -1) { // If not visited
                    distance[neighbor] = dist + 1;
                    queue.add(neighbor);
                }
            }
        }

        return distance;
    }
}
