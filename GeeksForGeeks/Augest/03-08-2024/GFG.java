class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
         int n = mat.length;
        int candidate = 0;

        // Step 1: Find the candidate for the celebrity
        for (int i = 1; i < n; i++) {
            if (mat[candidate][i] == 1) {
                // candidate knows i, so candidate cannot be a celebrity
                candidate = i;
            }
            // if mat[candidate][i] == 0, candidate might still be the celebrity
        }

        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                // candidate should not know i
                if (mat[candidate][i] == 1) {
                    return -1;
                }
                // i should know candidate
                if (mat[i][candidate] == 0) {
                    return -1;
                }
            }
        }

        return candidate;
    }
}
