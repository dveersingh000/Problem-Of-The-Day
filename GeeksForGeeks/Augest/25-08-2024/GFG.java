class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    public long countPairs(int arr[], int brr[], int M, int N) {
        // code here
        Arrays.sort(brr);
        
        // Special count for how many 0s, 1s, 2s, 3s, and 4s in brr[].
        int[] specialCount = new int[5];
        for (int y : brr) {
            if (y < 5) {
                specialCount[y]++;
            }
        }
        
        long totalPairs = 0;
        
        // Traverse all elements of arr[].
        for (int x : arr) {
            // For x = 0, it can never form a valid pair since 0^y is always 0.
            if (x == 0) continue;
            
            // For x = 1, x^y will be 1 for all y, so it can't be greater than y^x.
            if (x == 1) {
                totalPairs += 0;
                continue;
            }
            
            // Using binary search, find the first element in brr[] greater than x.
            int idx = Arrays.binarySearch(brr, x);
            if (idx < 0) {
                idx = -(idx + 1); // find insertion point
            } else {
                while (idx < N && brr[idx] == x) {
                    idx++;
                }
            }
            
            // Add count of elements greater than x
            totalPairs += (N - idx);
            
            // Handle special cases:
            // If x = 2, add count of brr[] elements with y = 3 or 4 (because 2^3 > 3^2 and 2^4 > 4^2).
            if (x == 2) totalPairs -= (specialCount[3] + specialCount[4]);
            
            // If x = 3, add count of brr[] elements with y = 2 (because 3^2 > 2^3).
            if (x == 3) totalPairs += specialCount[2];
            
            // Every pair with x > 2 and y = 1 satisfies x^y > y^x.
            totalPairs += specialCount[1];
        }
        
        return totalPairs;
    }
}
