class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustCounts = new int[n + 1];
        int[] trustedCounts = new int[n + 1];
        
        for (int[] relation : trust) {
            int personA = relation[0];
            int personB = relation[1];
            trustCounts[personA]++;
            trustedCounts[personB]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (trustCounts[i] == 0 && trustedCounts[i] == n - 1) {
                return i; 
            }
        }
        
        return -1;
    }
}