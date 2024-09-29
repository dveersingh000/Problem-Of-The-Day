public class TotalCount {

    public static int totalCount(int[] arr, int k) {
        int totalParts = 0;

        // Loop through each element in the array
        for (int x : arr) {
            // Calculate the number of parts needed for the element x
            totalParts += (x + k - 1) / k;
        }

        return totalParts;
    }

    public static void main(String[] args) {
        // Example 1
        int[] arr1 = {5, 8, 10, 13};
        int k1 = 3;
        System.out.println("Output for Example 1: " + totalCount(arr1, k1));  // Output: 14

        // Example 2
        int[] arr2 = {10, 2, 3, 4, 7};
        int k2 = 4;
        System.out.println("Output for Example 2: " + totalCount(arr2, k2));  // Output: 8
    }
}
