class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        // code here
         int n = str1.length();
        int m = str2.length();
        
        // Create a 2D DP array with all values initialized to 0
        int[][] dp = new int[n + 1][m + 1];
        
        int maxLength = 0; // To store the length of the longest common substring
        
        // Fill the DP array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // If characters match, extend the length of the common substring
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    // Update maxLength if this substring is longer
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    // If characters do not match, reset the length
                    dp[i][j] = 0;
                }
            }
        }
        
        return maxLength;
    }
}
