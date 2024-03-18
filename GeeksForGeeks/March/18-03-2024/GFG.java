class Solution
{
    //Function to return the level order traversal of a tree.
    static ArrayList <Integer> levelOrder(Node root) 
    {
        // Your code here
        Queue<Node> queue = new LinkedList<Node>();
        ArrayList<Integer> ans = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) 
        {
            Node tempNode = queue.poll();
            ans.add(tempNode.data);
 
            if (tempNode.left != null)
                queue.add(tempNode.left);
 
            if (tempNode.right != null)
                queue.add(tempNode.right);
        }
        
        return ans;
    }
}
