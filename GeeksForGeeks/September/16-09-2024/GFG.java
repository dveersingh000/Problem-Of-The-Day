class Solution {
    static int maxLength(String S) {
        // Stack to store indices of parentheses
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Initial index to calculate the first valid substring
        int maxLength = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push(i); // Push index of '(' onto the stack
            } else {
                stack.pop(); // Pop the matching '('
                
                if (stack.isEmpty()) {
                    stack.push(i); // Push current index if stack is empty (reset point)
                } else {
                    // Calculate the length of the current valid substring
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }
}
