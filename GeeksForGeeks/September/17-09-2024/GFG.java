class Solution {
    int getMinDiff(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        
        int n = arr.length;
        
        // Initial maximum possible difference before any modifications
        int diff = arr[n - 1] - arr[0];
        
        // Initialize the new smallest and largest possible values
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;
        
        for (int i = 0; i < n - 1; i++) {
            int minHeight = Math.min(smallest, arr[i + 1] - k);  // Min height after modification
            int maxHeight = Math.max(largest, arr[i] + k);       // Max height after modification
            
            // Update the difference
            if (minHeight < 0) continue;  // Skip negative heights
            diff = Math.min(diff, maxHeight - minHeight);
        }
        
        return diff;
    }
}
