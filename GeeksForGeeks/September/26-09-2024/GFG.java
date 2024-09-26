class Solution {
    // Function to find maximum number of consecutive steps
    // to gain an increase in altitude with each step.
    public int maxStep(int arr[]) {
        // Edge case: If the array has less than 2 elements
        if (arr.length < 2) return 0;

        int maxSteps = 0;
        int currentSteps = 0;

        // Loop through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                // If current element is greater than previous, increment the step counter
                currentSteps++;
            } else {
                // If not increasing, reset the step counter
                currentSteps = 0;
            }
            // Update maximum steps encountered
            maxSteps = Math.max(maxSteps, currentSteps);
        }
        return maxSteps;
    }
}
