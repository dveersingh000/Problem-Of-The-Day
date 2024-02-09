class Solution
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // add your code here
        if(root == null)
            return 1;
        
        // if the root is a leaf node, return 1 (property holds for leaf)
        if(root.left == null && root.right == null)
            return 1;
        
        // calculate the sum of left and right child nodes
        int sum = 0;
        if(root.left != null)
            sum += root.left.data;
        if(root.right != null)
            sum += root.right.data;
        
        // if the sum does not match the root's data, return 0
        if(sum != root.data)
            return 0;
        
        // recursively check left and right subtrees
        return isSumProperty(root.left) & isSumProperty(root.right);
        
    }
}