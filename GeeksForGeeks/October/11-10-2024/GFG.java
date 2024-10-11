class Solution {
    public List<Integer> rearrange(List<Integer> arr) {
        int n = arr.size();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }
        for (int i = 0; i < n; i++) {
            int value = arr.get(i);
            if (value >= 0 && value < n) {
                result.set(value, value);
            }
        }
        
        return result;
    }
}
