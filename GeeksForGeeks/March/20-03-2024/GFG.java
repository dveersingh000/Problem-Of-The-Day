class Solution
{
    int ans=0;
    public int sumOfLongRootToLeafPath(Node root)
    {
        //code here
        int ht=getH(root);
        ans=0;
        solve(root,ht,1,root.data);
        return ans;
    }
    
    
    public int getH(Node root)
    {
        if(root==null)
            return 0;
    
        int l=getH(root.left);
        int r=getH(root.right);
    
        return Math.max(l,r)+1;
    }

    void solve(Node root,int ht,int c,int sum)
    {
        if(root==null)
            return;
        if(c==ht)
            ans=Math.max(ans,sum);
    
        if(root.left!=null)
            solve(root.left,ht,c+1,sum+root.left.data);
        if(root.right!=null)
            solve(root.right,ht,c+1,sum+root.right.data);
    }
}
