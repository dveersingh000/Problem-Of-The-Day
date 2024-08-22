class Solution {
    public String findOrder(String[] dict, int n, int k) {
        // Write your code here\
         List<Integer>[] adjList = new ArrayList[k];
        for (int i = 0; i < k; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        // Step 2: Build the graph
        for (int i = 0; i < n - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];
            int len = Math.min(word1.length(), word2.length());
            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList[word1.charAt(j) - 'a'].add(word2.charAt(j) - 'a');
                    break;
                }
            }
        }
        
        // Step 3: Perform topological sort using Kahn's Algorithm (BFS)
        int[] inDegree = new int[k];
        for (int i = 0; i < k; i++) {
            for (int neighbor : adjList[i]) {
                inDegree[neighbor]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.append((char) (current + 'a'));
            
            for (int neighbor : adjList[current]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // If the result length is not equal to k, return empty string (cycle detection case)
        if (result.length() != k) {
            return "";
        }
        
        return result.toString();
    }
}
