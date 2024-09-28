class Solution {
    public int minimizeCost(int k, int arr[]) {
        // code here
        int n = arr.length;
        // Create a dp array to store the minimum cost to reach each stone
        int[] dp = new int[n];
        
        // Initialize the first stone cost
        dp[0] = 0; // No cost to reach the first stone
        
        // Fill the dp array
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE; // Initialize with a large number
            
            // Check the last k stones
            for (int j = Math.max(0, i - k); j < i; j++) {
                int cost = dp[j] + Math.abs(arr[i] - arr[j]);
                dp[i] = Math.min(dp[i], cost);
            }
        }
        
        // Return the cost to reach the last stone
        return dp[n - 1];
    }
}
