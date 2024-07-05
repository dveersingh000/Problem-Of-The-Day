class Solution {
    private void solve(Node root, int x, int[] bounds) {
        if (root == null) {
            return;
        }
        bounds[0] = Math.max(bounds[0], x);
        bounds[1] = Math.min(bounds[1], x);
        solve(root.left, x - 1, bounds);
        solve(root.right, x + 1, bounds);
    }

    public int verticalWidth(Node root) {
        if (root == null) {
            return 0;
        }
        int[] bounds = {0, 0};
        solve(root, 0, bounds);
        return bounds[0] - bounds[1] + 1;
    }
}
