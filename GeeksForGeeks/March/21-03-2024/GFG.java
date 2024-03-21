class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    //Add your code here.
	    ArrayList<Integer> al = new ArrayList<>();
        boolean flag = false;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
    
        while(!q.isEmpty())
        {
            int s = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
        
            while(s>0)
            {
                Node n = q.remove();
                s--;
                if(flag)
                    temp.add(0, n.data);
                else
                    temp.add(n.data);
                if(n.left!=null)
                    q.add(n.left);
                if(n.right!=null)
                    q.add(n.right);
            }
        
            flag = !flag;
            al.addAll(temp);
        }
        
        return al;
	}
}
