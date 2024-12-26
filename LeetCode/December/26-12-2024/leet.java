class Solution {
    public int solve(int[] nums, int target, int i, int currSum){
        if(i == nums.length){
            if(currSum == target){
                return 1;
            }else {
                return 0;
            }
        }
        int plus = solve(nums, target, i+1, currSum + nums[i]);
        int minus = solve(nums, target, i+1, currSum - nums[i]);
        
        return plus + minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, 0, 0);
    }
}
