class Solution {
    public int findMaxDiff(int[] arr) {
        // code here
        int n = arr.length;
        int[] ls = new int[n];
        int[] rs = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Finding left smaller elements
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ls[i] = 0;
            } else {
                ls[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        
        stack.clear();
        
        // Finding right smaller elements
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rs[i] = 0;
            } else {
                rs[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        
        // Calculating the maximum absolute difference
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(ls[i] - rs[i]);
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        
        return maxDiff;
    }
}
