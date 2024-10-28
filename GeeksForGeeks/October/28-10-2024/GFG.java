class Solution {
    ArrayList<Integer> removeDuplicate(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();

        for (int num : arr) {
            if (seen.add(num)) {
                result.add(num);
            }
        }
        return result;
    }
}
