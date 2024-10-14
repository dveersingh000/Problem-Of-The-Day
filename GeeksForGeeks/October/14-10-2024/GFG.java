class Solution {
    // Function to count nodes of a linked list.
    public int getCount(Node head) {
        // code here
        // Initialize count to 0
        int count = 0;
        
        // Traverse the linked list
        Node current = head;  // Start with the head node
        while (current != null) {
            count++;  // Increment count for each node
            current = current.next;  // Move to the next node
        }
        
        // Return the total count of nodes
        return count;
    }
}
