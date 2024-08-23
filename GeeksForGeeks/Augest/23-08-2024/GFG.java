import java.util.*;

class Tree {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node currentNode = current.node;
            int level = current.level;

            // If this is the first node of the current level, add it to the result.
            if (result.size() == level) {
                result.add(currentNode.data);
            }

            // Enqueue left and right children of the current node.
            if (currentNode.left != null) {
                queue.add(new Pair(currentNode.left, level + 1));
            }
            if (currentNode.right != null) {
                queue.add(new Pair(currentNode.right, level + 1));
            }
        }

        return result;
    }
}

// Helper class to store a tree node along with its level
class Pair {
    Node node;
    int level;

    Pair(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}

// Definition for a binary tree node.
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
