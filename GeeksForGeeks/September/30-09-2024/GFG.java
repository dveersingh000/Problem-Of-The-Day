class Solution {
    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.
    public List<Integer> merge(Node root1, Node root2) {
        // Lists to store inorder traversal of both trees.
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        // Perform inorder traversal of both trees.
        inorderTraversal(root1, list1);
        inorderTraversal(root2, list2);
        
        // Merge the two sorted lists.
        return mergeSortedLists(list1, list2);
    }
    
    // Function to perform inorder traversal of a BST and store it in a list.
    private void inorderTraversal(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list); // Visit left subtree
        list.add(root.data);               // Visit root
        inorderTraversal(root.right, list);// Visit right subtree
    }
    
    // Function to merge two sorted lists.
    private List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;
        
        // Merge the two lists
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }
        
        // Add remaining elements from list1 (if any)
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }
        
        // Add remaining elements from list2 (if any)
        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }
        
        return mergedList;
    }
}
