class Solve {
    int[] findTwoElement(int arr[], int n) {
        int[] result = new int[2]; // result[0] = repeating, result[1] = missing

        // Step 1: Identify the repeating element
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]) - 1; // Convert value to index (1-based to 0-based)
            
            // If the value at the index is negative, it means this number is repeated
            if (arr[index] < 0) {
                result[0] = Math.abs(arr[i]); // The repeating element
            } else {
                // Mark the element by negating it
                arr[index] = -arr[index];
            }
        }

        // Step 2: Identify the missing element
        for (int i = 0; i < n; i++) {
            // If the value is positive, that index + 1 is the missing number
            if (arr[i] > 0) {
                result[1] = i + 1; // The missing element (index is 0-based, so add 1)
            }
        }

        return result;
    }
}
