class Solution {
    public int editDistance(String str1, String str2) {
        // Code here
        int m = str1.length();
        int n = str2.length();

        // Create a 2D array to store the distances
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // cost of deleting all characters from str1 to match an empty str2
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // cost of inserting all characters into an empty str1 to match str2
        }

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // No operation needed if characters match
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, // Deletion
                                        Math.min(dp[i][j - 1] + 1, // Insertion
                                                 dp[i - 1][j - 1] + 1)); // Replacement
                }
            }
        }

        // Return the result
        return dp[m][n];
    }
}
