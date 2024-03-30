class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) 
    {
        // code here
        Node current = root;
 
        while (current.left != null)
            current = current.left;
        
        return (current.data);
    }
}
