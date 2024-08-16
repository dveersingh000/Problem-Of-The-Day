class Solution
{
    public int maximizeCuts(int n, int x, int y, int z)
    {
        // Create a dp array initialized with a very small value (here -1)
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        // Base case: No cuts for length 0
        dp[0] = 0;
        
        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            if (i >= x && dp[i - x] != -1) {
                dp[i] = Math.max(dp[i], dp[i - x] + 1);
            }
            if (i >= y && dp[i - y] != -1) {
                dp[i] = Math.max(dp[i], dp[i - y] + 1);
            }
            if (i >= z && dp[i - z] != -1) {
                dp[i] = Math.max(dp[i], dp[i - z] + 1);
            }
        }
        
        // If dp[n] is still -1, it means no valid cuts were possible
        return dp[n] == -1 ? 0 : dp[n];
    }
}
