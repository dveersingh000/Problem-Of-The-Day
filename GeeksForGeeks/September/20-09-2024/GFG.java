class Solution {
    // Returns count buildings that can see sunlight
    public int countBuildings(int[] height) {
        // code here
         if (height.length == 0) return 0;

        // First building can always see the sunrise
        int count = 1;
        int max_height = height[0];
        
        // Traverse the buildings from the second one
        for (int i = 1; i < height.length; i++) {
            if (height[i] > max_height) {
                count++; // This building can see the sunrise
                max_height = height[i]; // Update the max height
            }
        }
        return count;
    }
}
