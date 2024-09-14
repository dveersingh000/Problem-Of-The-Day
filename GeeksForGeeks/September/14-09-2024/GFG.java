class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        ArrayList<Integer> positives = new ArrayList<>();
        ArrayList<Integer> negatives = new ArrayList<>();
        
        // Separate the numbers into positive and negative lists
        for (int num : arr) {
            if (num >= 0) {
                positives.add(num);
            } else {
                negatives.add(num);
            }
        }
        
        // Now, let's merge the positives and negatives alternately
        int i = 0, posIndex = 0, negIndex = 0;
        
        // Use two pointers to alternate between positives and negatives
        while (posIndex < positives.size() && negIndex < negatives.size()) {
            // Add a positive number
            if (i % 2 == 0) {
                arr.set(i, positives.get(posIndex++));
            } 
            // Add a negative number
            else {
                arr.set(i, negatives.get(negIndex++));
            }
            i++;
        }
        
        // Add the remaining positive numbers (if any)
        while (posIndex < positives.size()) {
            arr.set(i++, positives.get(posIndex++));
        }
        
        // Add the remaining negative numbers (if any)
        while (negIndex < negatives.size()) {
            arr.set(i++, negatives.get(negIndex++));
        }
    }
}
