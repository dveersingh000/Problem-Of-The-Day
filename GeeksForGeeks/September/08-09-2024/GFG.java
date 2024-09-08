class Solution {
    static int minJumps(int[] arr) {
        // your code here
        int n = arr.length;
        
        // If the array has only one element, no jump is needed
        if (n == 1) return 0;
        
        // If the first element is 0, it's impossible to jump anywhere
        if (arr[0] == 0) return -1;
        
        int maxReach = arr[0];  // The farthest we can reach
        int steps = arr[0];     // Steps we can still take within the current jump
        int jumps = 1;          // The number of jumps made
        
        for (int i = 1; i < n; i++) {
            // If we have reached the last element
            if (i == n - 1) {
                return jumps;
            }
            
            // Update the maxReach
            maxReach = Math.max(maxReach, i + arr[i]);
            
            // Decrease the steps for the current jump
            steps--;
            
            // If no more steps are left
            if (steps == 0) {
                // We must do another jump
                jumps++;
                
                // If the current position is beyond the maxReach, return -1
                if (i >= maxReach) {
                    return -1;
                }
                
                // Reset the steps to the amount of steps to reach maxReach
                steps = maxReach - i;
            }
        }
        
        return -1;
    }
}
