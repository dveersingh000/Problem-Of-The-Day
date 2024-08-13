class Solution {
    long floorSqrt(long n) {
        // Your code here
        if (n == 0 || n == 1) {
            return n;
        }
        
        long start = 1, end = n, result = 0;
        
        while (start <= end) {
            long mid = start + (end - start) / 2;
            
            // Check if mid * mid is less than or equal to n
            if (mid * mid == n) {
                return mid; // Perfect square case
            } else if (mid * mid < n) {
                start = mid + 1;
                result = mid; // Update result as mid * mid < n
            } else {
                end = mid - 1;
            }
        }
        
        return result;
    }
}
