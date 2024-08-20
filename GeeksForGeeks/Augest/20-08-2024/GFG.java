class Solution
{
    // static class Node {
    //     int data;
    //     Node left, right;
        
    //     Node(int data) {
    //         this.data = data;
    //         left = right = null;
    //     }
    // }
    
    // Helper function to map parents of all nodes
    private static void mapParents(Node root, Map<Node, Node> parentMap, Node targetNode, int target, Queue<Node> q) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.data == target) {
                q.add(node); // Enqueue the target node for BFS later
            }
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.add(node.right);
            }
        }
    }

    public static int minTime(Node root, int target) {
        // To store the parent of each node
        Map<Node, Node> parentMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        // Map parents and find the target node
        mapParents(root, parentMap, root, target, q);
        
        // To track visited nodes to avoid revisiting
        Set<Node> visited = new HashSet<>();
        visited.add(q.peek());
        
        int time = 0;
        
        // BFS for burning tree simulation
        while (!q.isEmpty()) {
            int size = q.size();
            boolean burned = false;
            
            for (int i = 0; i < size; i++) {
                Node current = q.poll();
                
                // Try to burn the left child
                if (current.left != null && !visited.contains(current.left)) {
                    visited.add(current.left);
                    q.add(current.left);
                    burned = true;
                }
                
                // Try to burn the right child
                if (current.right != null && !visited.contains(current.right)) {
                    visited.add(current.right);
                    q.add(current.right);
                    burned = true;
                }
                
                // Try to burn the parent
                Node parent = parentMap.get(current);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    q.add(parent);
                    burned = true;
                }
            }
            
            // Increment time if any node was burned in this round
            if (burned) {
                time++;
            }
        }
        
        return time;
    }
}
