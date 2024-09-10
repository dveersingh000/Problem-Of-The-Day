class Solution {
    public int isCircle(String arr[]) {
        // code here
        int n = arr.length;
        
        int[] inDegree = new int[26];
        int[] outDegree = new int[26];
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        for (String str : arr) {
            int firstChar = str.charAt(0) - 'a'; 
            int lastChar = str.charAt(str.length() - 1) - 'a'; 

            outDegree[firstChar]++;
            inDegree[lastChar]++;
            graph.get(firstChar).add(lastChar);
        }

        for (int i = 0; i < 26; i++) {
            if (inDegree[i] != outDegree[i]) {
                return 0;
            }
        }

        return isStronglyConnected(graph, arr[0].charAt(0) - 'a') ? 1 : 0;
    }

    private boolean isStronglyConnected(ArrayList<ArrayList<Integer>> graph, int start) {
        boolean[] visited = new boolean[26];
        dfs(graph, start, visited);

        for (int i = 0; i < 26; i++) {
            if (!graph.get(i).isEmpty() && !visited[i]) {
                return false;
            }
        }

        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            transpose.add(new ArrayList<>());
        }

        for (int i = 0; i < 26; i++) {
            for (int neighbor : graph.get(i)) {
                transpose.get(neighbor).add(i);
            }
        }

        Arrays.fill(visited, false);
        dfs(transpose, start, visited);

        for (int i = 0; i < 26; i++) {
            if (!transpose.get(i).isEmpty() && !visited[i]) {
                return false;
            }
        }

        return true;
    }

    private void dfs(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }
}
