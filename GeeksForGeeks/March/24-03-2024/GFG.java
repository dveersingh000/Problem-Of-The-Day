class Solution {
    Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        Stack<Integer> tmp = new Stack<>();
        
       
        while (!st.isEmpty()) {
            tmp.push(st.pop());
        }
        
        
        st.push(x);
        
        
        while (!tmp.isEmpty()) {
            st.push(tmp.pop());
        }
        
        return st;
    }

}
