class Solution {
    static int subArraySum(int[] arr, int target) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int curr_sum = 0;
        int count = 0;

        prefixSumMap.put(0, 1); 

        for (int num : arr) {
            curr_sum += num;
            if (prefixSumMap.containsKey(curr_sum - target)) {
                count += prefixSumMap.get(curr_sum - target);
            }
            prefixSumMap.put(curr_sum, prefixSumMap.getOrDefault(curr_sum, 0) + 1);
        }

        return count;
    }
}
