class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        if (arr.length == 0) {
            return "-1";
        }
        
        // Start with the first string as the base prefix
        String prefix = arr[0];
        
        // Compare prefix with each string in the array
        for (int i = 1; i < arr.length; i++) {
            // Check the current string against the prefix
            while (arr[i].indexOf(prefix) != 0) {
                // Reduce the prefix by one character from the end
                prefix = prefix.substring(0, prefix.length() - 1);
                // If the prefix is empty, return "-1"
                if (prefix.isEmpty()) {
                    return "-1";
                }
            }
        }
        
        return prefix;
    }
}
