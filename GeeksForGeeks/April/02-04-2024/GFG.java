class Solution
{
    
    int absolute_diff(Node root)
    {
        //Your code here
        int ans = Integer.MAX_VALUE;
        int prev = -1;
        Deque<Node> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) 
        {
            while (root != null) 
            {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if (prev >= 0)
                ans = Math.min(ans, root.data - prev);
            
            prev = root.data;
            root = root.right;
        }

        return ans;
    }
}
