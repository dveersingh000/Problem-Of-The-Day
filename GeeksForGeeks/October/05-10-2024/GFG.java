class Solution {
    public long findSmallest(int[] arr) {
        long result = 1; // Initialize the result to 1 (smallest positive integer)
        
        // Traverse through the sorted array
        for (int i = 0; i < arr.length; i++) {
            // If the current element is greater than the result, return result
            if (arr[i] > result) {
                break;
            }
            // Otherwise, add the element to result
            result += arr[i];
        }
        
        return result; // Return the smallest number that cannot be formed
    }
}
