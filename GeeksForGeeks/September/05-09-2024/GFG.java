class Solution {
    int missingNumber(int n, int arr[]) {
        int xorTotal = 0;
        for (int i = 1; i <= n; i++) {
            xorTotal ^= i;
        }
        int xorArray = 0;
        for (int i = 0; i < n - 1; i++) {
            xorArray ^= arr[i];
        }
        return xorTotal ^ xorArray;
    }
}
