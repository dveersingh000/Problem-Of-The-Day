class Solution {
    long sumBitDifferences(int[] arr, int n) {
       
        long result = 0;
        
        for (int i = 0; i < 32; i++) {
            int countSetBits = 0;
            
            for (int j = 0; j < n; j++) {
                if ((arr[j] & (1 << i)) != 0) {
                    countSetBits++;
                }
            }
            
            result += (long) countSetBits * (n - countSetBits) * 2;
        }
        
        return result;
    }
}