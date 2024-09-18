class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here
         Stack<Character> stack = new Stack<>();

        // Traversing each character in the string.
        for (int i = 0; i < x.length(); i++) {
            char ch = x.charAt(i);

            // If it's an opening bracket, push it to the stack.
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // If it's a closing bracket, check for the matching opening bracket.
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If stack is empty, no matching opening bracket.
                if (stack.isEmpty()) {
                    return false;
                }
                // Check if the top of the stack matches the current closing bracket.
                char top = stack.peek();
                if ((ch == ')' && top == '(') ||
                    (ch == '}' && top == '{') ||
                    (ch == ']' && top == '[')) {
                    stack.pop(); // Pop the matching opening bracket.
                } else {
                    return false; // Mismatch found.
                }
            }
        }

        // If the stack is empty, all brackets are balanced.
        return stack.isEmpty();
    }
}
