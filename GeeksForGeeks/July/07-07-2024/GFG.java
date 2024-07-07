class Solution {

    private boolean findAncestors(Node root, int target, ArrayList<Integer> ancestors) {
        if (root == null) return false;

        if (root.data == target) return true;

        if (findAncestors(root.left, target, ancestors) || 
            findAncestors(root.right, target, ancestors)) {
            ancestors.add(root.data);
            return true;
        }

        return false;
    }

    public ArrayList<Integer> Ancestors(Node root, int target) {
        ArrayList<Integer> ancestors = new ArrayList<>();
        findAncestors(root, target, ancestors);
        return ancestors;
    }
}
