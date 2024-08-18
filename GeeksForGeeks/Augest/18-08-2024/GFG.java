
class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        int n = arr.length;
        if (n < 2) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int leftSum = 0;
        for (int i = 0; i < n - 1; i++) {
            leftSum += arr[i];
            if (leftSum == sum / 2) {
                return true;
            }
        }
        return false;
    }
}
