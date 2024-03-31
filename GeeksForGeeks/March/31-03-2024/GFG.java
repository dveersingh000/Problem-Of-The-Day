class Solution {
    public static int findMaxForN(Node root, int n) {
        int maxVal = -1;
        while (root != null) {
            if (root.key <= n) {
                maxVal = Math.max(maxVal, root.key);
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return maxVal;
    }

}
