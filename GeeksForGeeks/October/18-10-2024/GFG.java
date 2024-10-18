class Solution {
    int getSingle(int arr[]) {
        int xr = 0;
        for (int num : arr) {
            xr ^= num; 
        }
        return xr;
    }
}
