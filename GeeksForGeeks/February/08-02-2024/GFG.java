class Solution
{
    boolean check(Node root)
    {
	// Your code here
	if (root == null)
            return true;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        int leafLevel = -1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                
                if (node.left == null && node.right == null) {
                    if (leafLevel == -1) {
                        // Set the level of the first leaf node encountered
                        leafLevel = level;
                    } else if (level != leafLevel) {
                        // If leaf nodes are encountered at different levels, return false
                        return false;
                    }
                }
                
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        
        // All leaf nodes are at the same level
        return true;
    }
}