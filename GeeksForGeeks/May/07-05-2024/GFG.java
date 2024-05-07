class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) 
        {
            int levelSize = queue.size();
            ArrayList<Integer> levelNodes = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) 
            {
                Node current = queue.poll();
                levelNodes.add(current.data);

                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }

            result.addAll(0, levelNodes);
        }

        return result;
    }
}      
