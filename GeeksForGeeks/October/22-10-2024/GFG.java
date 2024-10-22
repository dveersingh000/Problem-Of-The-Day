class Solution {

    static int sameOccurrence(int[] arr, int x, int y) {
        HashMap<Integer, Integer> diffCount = new HashMap<>(); 
        int diff = 0;  
        int result = 0;

        diffCount.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) diff++;        
            else if (arr[i] == y) diff--;   

            result += diffCount.getOrDefault(diff, 0);

            diffCount.put(diff, diffCount.getOrDefault(diff, 0) + 1);
        }

        return result;
    }
}