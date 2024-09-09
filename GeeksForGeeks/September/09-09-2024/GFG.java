class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        // code here
        int low = 0, mid = 0, high = arr.size() - 1;
        
        // Traverse through the array
        while (mid <= high) {
            if (arr.get(mid) == 0) {
                // Swap arr[low] and arr[mid], and move both pointers
                int temp = arr.get(low);
                arr.set(low, arr.get(mid));
                arr.set(mid, temp);
                low++;
                mid++;
            } else if (arr.get(mid) == 1) {
                // Just move the mid pointer as 1 is in the correct place
                mid++;
            } else {
                // Swap arr[mid] and arr[high], and move only the high pointer
                int temp = arr.get(mid);
                arr.set(mid, arr.get(high));
                arr.set(high, temp);
                high--;
            }
        }
    }
}
