class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // code here
        String[] words = str.split("\\.");
        
        // Step 2: Initialize an empty StringBuilder to store the result
        StringBuilder result = new StringBuilder();
        
        // Step 3: Traverse the words array in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            // Add a dot if it's not the last word
            if (i != 0) {
                result.append(".");
            }
        }
        
        // Step 4: Convert StringBuilder to string and return
        return result.toString();
    }
}
