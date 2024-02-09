class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        
        // Initialize dp array to store the length of largest divisible subset
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        // Initialize prev array to store index of previous element in subset
        int[] prev = new int[nums.length];
        Arrays.fill(prev, -1);
        
        // Initialize variables to store maximum length and its index
        int maxLen = 0;
        int maxIndex = -1;
        
        // Iterate over nums array to calculate dp and prev arrays
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            // Update maximum length and its index
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }
        
        // Construct the largest divisible subset using prev array
        List<Integer> subset = new ArrayList<>();
        while (maxIndex != -1) {
            subset.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        
        return subset;
    
    }
}