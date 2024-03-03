class Solution {
    String printLargest(int n, String[] arr) {
        // Define a custom comparator for sorting the strings
        Comparator<String> customComparator = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                // Compare the two concatenated strings in reverse order
                return order2.compareTo(order1);
            }
        };
        
        // Sort the array of strings using the custom comparator
        Arrays.sort(arr, customComparator);
        
        // Handle the case where the array consists of only zeros
        if (arr[0].equals("0")) {
            return "0";
        }
        
        // Concatenate the sorted strings to form the largest number
        StringBuilder result = new StringBuilder();
        for (String str : arr) {
            result.append(str);
        }
        
        return result.toString();
    }
}