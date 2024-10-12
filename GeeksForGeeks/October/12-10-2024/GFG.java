class Solution {
    public int pairWithMaxSum(int[] arr) {
        // code here
        if (arr.length < 2) {
            return -1;
        }
        
        // Variable to store maximum sum of adjacent pairs
        int maxSum = Integer.MIN_VALUE;
        
        // Loop through the array to find consecutive pair sums
        for (int i = 0; i < arr.length - 1; i++) {
            int currentSum = arr[i] + arr[i + 1];
            // Update maxSum if the current sum is larger
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        
        // Return the maximum sum found
        return maxSum;
    }
}
