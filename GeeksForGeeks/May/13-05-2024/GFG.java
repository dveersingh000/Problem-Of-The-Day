class Solution {
    public static int findNumberOfGoodComponent(int e, int v, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v + 1);
        for (int i = 0; i <= v; i++)
            adj.add(new ArrayList<Integer>());
        
        for (int[] edge : edges) 
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int ans = 0;
        int[] visited = new int[v + 1];
        
        for (int i = 1; i <= v; i++) 
        {
            if (visited[i] == 0) 
            {
                int[] vertices = { 0 };
                int[] edgeCount = { 0 };
                
                dfs(i, vertices, edgeCount, adj, visited);
                edgeCount[0] /= 2;
                
                if (edgeCount[0] == (vertices[0] * (vertices[0] - 1)) / 2)
                    ans++;
            }

        }

        return ans;
    }
    
    
    private static void dfs(int v, int[] vertices, int[] edges, ArrayList<ArrayList<Integer>> adj, int[] visited) 
    {
        visited[v] = 1;
        vertices[0]++;
        edges[0] += adj.get(v).size();
        
        for (int to : adj.get(v))
            if (visited[to] == 0)
                dfs(to, vertices, edges, adj, visited);
    }
}
