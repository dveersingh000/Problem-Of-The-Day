import java.util.*;

class Solution {
    // Function to find the smallest window in the string s consisting
    // of all the characters of string p.
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) {
            return "-1"; // No window possible
        }

        // Frequency map for characters in string p
        Map<Character, Integer> pFreqMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pFreqMap.put(c, pFreqMap.getOrDefault(c, 0) + 1);
        }

        // Variables to track the minimum window
        int minWindowLength = Integer.MAX_VALUE;
        int minWindowStart = 0;

        // Variables for the sliding window
        int left = 0, matched = 0;
        Map<Character, Integer> windowFreqMap = new HashMap<>();

        // Expanding the window by moving the right pointer
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            // Add the current character to the window frequency map
            windowFreqMap.put(rightChar, windowFreqMap.getOrDefault(rightChar, 0) + 1);

            // Check if the current character matches the required frequency in p
            if (pFreqMap.containsKey(rightChar) &&
                windowFreqMap.get(rightChar).intValue() == pFreqMap.get(rightChar).intValue()) {
                matched++;
            }

            // When we have a valid window (i.e., all characters from p are matched)
            while (matched == pFreqMap.size()) {
                // Check if this window is the smallest one so far
                int currentWindowLength = right - left + 1;
                if (currentWindowLength < minWindowLength) {
                    minWindowLength = currentWindowLength;
                    minWindowStart = left;
                }

                // Try to shrink the window by moving the left pointer
                char leftChar = s.charAt(left);
                if (windowFreqMap.containsKey(leftChar)) {
                    // Before removing the left character, check if it's part of p
                    if (pFreqMap.containsKey(leftChar) &&
                        windowFreqMap.get(leftChar).intValue() == pFreqMap.get(leftChar).intValue()) {
                        matched--;
                    }
                    windowFreqMap.put(leftChar, windowFreqMap.get(leftChar) - 1);
                }
                left++; // Move the left pointer
            }
        }

        // If no valid window is found, return -1
        return minWindowLength == Integer.MAX_VALUE ? "-1" : s.substring(minWindowStart, minWindowStart + minWindowLength);
    }
}
