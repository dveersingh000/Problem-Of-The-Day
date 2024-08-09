class Solution {

    private static final int MOD = 1000000007;

    int Maximize(int arr[]) {
        // Step 1: Sort the array in ascending order
        Arrays.sort(arr);

        long result = 0;
        int n = arr.length;

        // Step 2: Calculate the maximum value of ∑arr[i]*i
        for (int i = 0; i < n; i++) {
            result = (result + (long) arr[i] * i) % MOD;
        }

        // Step 3: Return the result as an integer
        return (int) result;
}
}
