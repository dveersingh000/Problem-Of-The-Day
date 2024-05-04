class GfG 
{
    private static int findPos(int[] in, int inStart, int inEnd, int elem) 
    {
        for (int i = inStart; i <= inEnd; i++) 
        {
            if (in[i] == elem) 
            {
                return i;
            }
        }
        return -1;
    }

    private static Node solve(int[] in, int[] post, int[] postIdx, int inStart, int inEnd, int n) 
    {
        if (postIdx[0] < 0 || inStart > inEnd) 
        {
            return null;
        }

        int elem = post[postIdx[0]--];
        Node root = new Node(elem);
        int pos = findPos(in, inStart, inEnd, elem);

        root.right = solve(in, post, postIdx, pos + 1, inEnd, n);
        root.left = solve(in, post, postIdx, inStart, pos - 1, n);

        return root;
    }

    // Function to return a tree created from postorder and inorder traversals.
    Node buildTree(int in[], int post[], int n) 
    {
        int[] postIdx = new int[]{n - 1};
        return solve(in, post, postIdx, 0, n - 1, n);
    }
}
