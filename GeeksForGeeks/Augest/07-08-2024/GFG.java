class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        // code here
        int n = arr1.length;
        int m = arr2.length;
        int[] arr = new int[n+m];
        for(int i=0; i<n; i++){
            arr[i] = arr1[i];
        }
        for(int i=0; i<m; i++){
            arr[n+i] = arr2[i];
        }
        Arrays.sort(arr);
        return arr[k - 1];
        
    }
}
