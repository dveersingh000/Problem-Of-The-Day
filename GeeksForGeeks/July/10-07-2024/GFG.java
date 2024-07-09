class Solution {
    public int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int closest_sum = Integer.MAX_VALUE;
        int n = arr.length;

        for (int i = 0; i < n - 2; ++i) {
            int left = i + 1, right = n - 1;

            while (left < right) {
                int current_sum = arr[i] + arr[left] + arr[right];

                if (current_sum == target) {
                    return current_sum;
                }

                if (Math.abs(current_sum - target) < Math.abs(closest_sum - target) || 
                   (Math.abs(current_sum - target) == Math.abs(closest_sum - target) && current_sum > closest_sum)) {
                    closest_sum = current_sum;
                }

                if (current_sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closest_sum;
    }
}
