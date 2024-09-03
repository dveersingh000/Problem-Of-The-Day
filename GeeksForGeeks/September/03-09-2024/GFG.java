class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int m = str1.length();
        int n = str2.length();
        
        // Create a DP table
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // LCS length
        int lcsLength = dp[m][n];
        
        // Calculate the number of deletions and insertions
        int deletions = m - lcsLength;
        int insertions = n - lcsLength;
        
        // Total operations
        return deletions + insertions;
	} 
}
