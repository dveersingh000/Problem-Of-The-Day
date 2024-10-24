class Solution {
    static ArrayList<Integer> modifyAndRearrangeArr(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != 0 && arr[i] == arr[i + 1]) {
                arr[i] = 2 * arr[i];
                arr[i + 1] = 0;
            }
        }

        int nonZeroIndex = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[nonZeroIndex++] = arr[i];
            }
        }

        while (nonZeroIndex < n) {
            arr[nonZeroIndex++] = 0;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
