class Solution 
{
    static Node prev;
    
    public Node flattenBST(Node root) 
    {
        // Code here
        Node dummy = new Node(-1);
        prev = dummy;
        
        Inorder(root);
  
        prev.left = null;
        prev.right = null;
        Node ret = dummy.right;
  
        return ret;
    }
    
    private void Inorder(Node curr)
    {
        if (curr == null)
            return;
        
        Inorder(curr.left);
        prev.left = null;
        prev.right = curr;
        prev = curr;
        Inorder(curr.right);
    }
}