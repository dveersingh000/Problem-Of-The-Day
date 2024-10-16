class Solution {
    public boolean checkSorted(List<Integer> arr) {
        int n = arr.size();
        int swapCnt = 0;

        for (int i = 0; i < n; i++) {
            if (arr.get(i) == i + 1) continue;
            while (arr.get(i) != i + 1) {
                Collections.swap(arr, arr.get(i) - 1, i);
                swapCnt++;
            }
        }
        return (swapCnt == 2 || swapCnt == 0);
    }
}
