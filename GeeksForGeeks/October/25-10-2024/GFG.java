class Solution {
    public static ArrayList<Integer> alternateSort(int[] arr) {
        Arrays.sort(arr); 
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>(n);

        int left = 0, right = n - 1;
        boolean highTurn = true;

        for (int i = 0; i < n; ++i) {
            if (highTurn) {
                ans.add(arr[right--]);
            } else {
                ans.add(arr[left++]);
            }
            highTurn = !highTurn;
        }

        return ans;
    }
}
