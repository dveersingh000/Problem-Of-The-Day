class Tree {
    public ArrayList<Integer> diagonalSum(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                while (node != null) {
                    if (node.left != null) queue.offer(node.left);
                    sum += node.data;
                    node = node.right;
                }
            }
            result.add(sum);
        }

        return result;
    }

}
