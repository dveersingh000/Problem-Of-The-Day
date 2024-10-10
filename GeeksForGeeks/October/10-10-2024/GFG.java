class Solution {
    public int maxDistance(int[] arr) {
        // HashMap to store the first occurrence of each element
        HashMap<Integer, Integer> firstOccurrence = new HashMap<>();
        int maxDist = 0;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            if (!firstOccurrence.containsKey(arr[i])) {
                // Store the index of the first occurrence
                firstOccurrence.put(arr[i], i);
            } else {
                // Calculate the distance and update maxDist
                int dist = i - firstOccurrence.get(arr[i]);
                maxDist = Math.max(maxDist, dist);
            }
        }

        return maxDist;
    }
}
