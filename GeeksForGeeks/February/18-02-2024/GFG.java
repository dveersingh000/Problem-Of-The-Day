class Solution
{
    static int sum;
    public static int sumOfLeafNodes(Node root)
    {
        // code here
        sum=0;
        return sum(root);
    }
    
    private static int sum(Node root)
    {
        if (root == null)
            return sum;
            
        if (root.left == null && root.right == null)
            sum += root.data;
      
        sum(root.left);
        sum(root.right);
        return sum;
    }
}