class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
        int n = arr1.length;
        
        // Merge the two sorted arrays
        int[] ar = new int[2 * n];
        int i = 0, j = 0, k = 0;
        
        while (i < n && j < n) {
            if (arr1[i] <= arr2[j]) {
                ar[k++] = arr1[i++];
            } else {
                ar[k++] = arr2[j++];
            }
        }
        
        // Copy remaining elements from arr1, if any
        while (i < n) {
            ar[k++] = arr1[i++];
        }
        
        // Copy remaining elements from arr2, if any
        while (j < n) {
            ar[k++] = arr2[j++];
        }
        
        // Find the middle elements
        int mid1 = (2 * n) / 2 - 1;
        int mid2 = mid1 + 1;
        
        return ar[mid1] + ar[mid2];
    }
}
