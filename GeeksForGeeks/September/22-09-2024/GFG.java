class Solution {
    int lps(String str) {
        int n = str.length();
        int[] lps = new int[n]; // Array to store longest prefix suffix lengths
        
        int len = 0; // Length of the previous longest prefix suffix
        int i = 1;   // Start from the second character
        
        // Loop to calculate lps[i] for i=1 to n-1
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    // Consider the previous longest prefix suffix
                    len = lps[len - 1];
                } else {
                    // If no match, lps[i] is 0
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        // The last value of the lps array contains the answer
        return lps[n - 1];
    }
}
