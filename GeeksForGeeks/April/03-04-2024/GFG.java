class Solution 
{
    public int kthCommonAncestor(Node root, int k, int x, int y) 
    {
        // code here
        List<Integer> ans = new ArrayList<>();
        Node node = root;
        
        while (node != null)
        {
            ans.add(node.data);
            
            if (node.data < x && node.data < y)
                node = node.right;
            else if (node.data > x && node.data > y)
                node = node.left;
            else
                break;
        }
        
        return (ans.size()-k >= 0) ? ans.get(ans.size()-k) : -1;
    }
}
