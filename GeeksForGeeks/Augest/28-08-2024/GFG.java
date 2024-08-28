class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freqMap.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                if (entry1.getValue() != entry2.getValue()) {
                    return entry2.getValue() - entry1.getValue(); // Descending order by frequency
                } else {
                    return entry1.getKey() - entry2.getKey(); // Ascending order by value if frequencies are the same
                }
            }
        });
        ArrayList<Integer> sortedArr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : entries) {
            for (int i = 0; i < entry.getValue(); i++) {
                sortedArr.add(entry.getKey());
            }
        }
        return sortedArr;
    }
}
