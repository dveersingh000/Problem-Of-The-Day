class Solution {
    // Helper function to check if the tree is a Sum Tree
    private boolean isSumTreeUtil(Node node, SumWrapper sum) {
        if (node == null) {
            sum.sum = 0;
            return true;
        }
        
        if (node.left == null && node.right == null) {
            sum.sum = node.data;
            return true;
        }
        
        SumWrapper leftSum = new SumWrapper();
        SumWrapper rightSum = new SumWrapper();
        
        boolean leftIsSumTree = isSumTreeUtil(node.left, leftSum);
        boolean rightIsSumTree = isSumTreeUtil(node.right, rightSum);
        
        sum.sum = leftSum.sum + rightSum.sum + node.data;
        
        return leftIsSumTree && rightIsSumTree && (node.data == leftSum.sum + rightSum.sum);
    }

    // Public function to check if the given tree is a Sum Tree
    boolean isSumTree(Node root) {
        SumWrapper sum = new SumWrapper();
        return isSumTreeUtil(root, sum);
    }

    // Wrapper class to hold sum
    class SumWrapper {
        int sum;
    }
}
