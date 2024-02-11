class Solution{
    static ArrayList<Integer> recamanSequence(int n){
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        result.add(0);
        set.add(0);

        for (int i = 1; i < n; i++) {
            int current = result.get(i - 1) - i;
            if (current < 0 || set.contains(current)) {
                current = result.get(i - 1) + i;
            }
            result.add(current);
            set.add(current);
        }

        return result;
    }
}