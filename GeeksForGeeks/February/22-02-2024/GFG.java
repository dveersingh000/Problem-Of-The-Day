class Solution {
    int MOD = 1000000007;
    
    int subsequenceCount(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i][j - 1]) % MOD;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}