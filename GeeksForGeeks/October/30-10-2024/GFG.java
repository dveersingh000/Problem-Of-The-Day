class Solution {
    public int countPairsWithDiffK(int[] arr, int k) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }

        int count = 0;
        for (int x : numSet) {
            if (numSet.contains(x + k)) {
                int countX = 0;
                int countXPlusK = 0;
                for (int num : arr) {
                    if (num == x) countX++;
                    if (num == x + k) countXPlusK++;
                }
                count += countX * countXPlusK;
            }
        }

        return count;
    }
}
