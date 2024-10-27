class Solution {
    public boolean findTriplet(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;

        Arrays.sort(arr); // Sort array

        for (int i = n - 1; i >= 2; i--) {
            int target = arr[i];
            int left = 0, right = i - 1;

            while (left < right) {
                int sum = arr[left] + arr[right];

                if (sum == target) return true;
                if (sum < target) {
                    left++; 
                } else {
                    right--; 
                }
            }
        }
        return false; 
    }
}
