class Solution {
    long numberOfPath(int n, int k, int [][]arr) {
        // code here
        long[][][] dp = new long[n][n][k + 1];
        
        // Base case: if the starting cell contains the required number of coins, set dp[0][0][arr[0][0]] to 1
        if (arr[0][0] <= k) {
            dp[0][0][arr[0][0]] = 1;
        }
        
        // Iterate through the matrix cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Skip the top-left cell, as it's already processed
                if (i == 0 && j == 0) {
                    continue;
                }
                
                // Iterate through the possible values of remaining coins
                for (int remaining = 0; remaining <= k; remaining++) {
                    // If the current cell contains more coins than the remaining, skip
                    if (arr[i][j] > remaining) {
                        continue;
                    }
                    
                    // Calculate the number of paths from the left cell
                    if (j > 0) {
                        dp[i][j][remaining] += dp[i][j - 1][remaining - arr[i][j]];
                    }
                    
                    // Calculate the number of paths from the top cell
                    if (i > 0) {
                        dp[i][j][remaining] += dp[i - 1][j][remaining - arr[i][j]];
                    }
                }
            }
        }
        
        // Return the number of paths from the bottom-right cell with exactly k coins
        return dp[n - 1][n - 1][k];
    }
}