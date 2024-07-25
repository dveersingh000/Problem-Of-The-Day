class Solution {
    public Node sortedArrayToBST(int[] nums) {
        // Code here
         return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    private Node sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        
        // Find the middle index
        int mid = left + (right - left) / 2;
        
        // Create a new Node with the middle element
        Node node = new Node(nums[mid]);
        
        // Recursively build the left and right subtrees
        node.left = sortedArrayToBSTHelper(nums, left, mid - 1);
        node.right = sortedArrayToBSTHelper(nums, mid + 1, right);
        
        return node;
    }
}
