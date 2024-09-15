class Solution
{
    Node prev = null;
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
	//  Your code here	
	if (root == null) return null;

        // To store the head of the DLL
        Node head = null;

        // Convert the left subtree and get the head of the DLL
        head = bToDLLUtil(root, head);

        return head;
    }

    // Utility function to perform in-order traversal and convert BT to DLL
    Node bToDLLUtil(Node root, Node head) {
        if (root == null) return head;

        // Recursively convert the left subtree
        head = bToDLLUtil(root.left, head);

        // If prev is null, it means this is the leftmost node (smallest value), which becomes the head
        if (prev == null) {
            head = root; // This will be the head of the doubly linked list
        } else {
            // Adjust the links for the DLL
            root.left = prev; // Set current node's left pointer to the previous node
            prev.right = root; // Set previous node's right pointer to the current node
        }

        // Move the previous node to the current node
        prev = root;

        // Recursively convert the right subtree
        head = bToDLLUtil(root.right, head);

        return head;
    }
}
