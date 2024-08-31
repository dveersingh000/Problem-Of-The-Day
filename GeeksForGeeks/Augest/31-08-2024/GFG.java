class Solution {
    // Function to find three numbers such that arr[smaller[i]] < arr[i] <
    // arr[greater[i]]
    public List<Integer> find3Numbers(int[] arr) {
        // code here
        int n = arr.length;
        if (n < 3) return new ArrayList<>(); 

        int[] smaller = new int[n];
        int[] greater = new int[n];
        Arrays.fill(smaller, -1);
        Arrays.fill(greater, -1);

        int min = 0;
        for (int i = 1; i < n; ++i) {
            if (arr[i] <= arr[min]) {
                min = i;
            } else {
                smaller[i] = min;
            }
        }

        int max = n - 1;
        for (int i = n - 2; i >= 0; --i) {
            if (arr[i] >= arr[max]) {
                max = i;
            } else {
                greater[i] = max;
            }
        }

        for (int i = 0; i < n; ++i) {
            if (smaller[i] != -1 && greater[i] != -1) {
                return Arrays.asList(arr[smaller[i]], arr[i], arr[greater[i]]);
            }
        }

        return new ArrayList<>(); 
    }
}
