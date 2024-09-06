class Solution {
    // Function to find the sum of contiguous subarray with maximum sum.
    maxSubarraySum(arr) {
        // Initialize maxSoFar to the first element of the array
        let maxSoFar = arr[0];
        // Initialize maxEndingHere to the first element of the array
        let maxEndingHere = arr[0];

        // Loop through the array starting from the second element
        for (let i = 1; i < arr.length; i++) {
            // Update maxEndingHere to either the current element itself
            // or the current element + maxEndingHere (to continue the subarray)
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            
            // Update maxSoFar if maxEndingHere is greater than maxSoFar
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        // Return the maximum sum found
        return maxSoFar;
    }
}
