class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // Add your code here.
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer by one
            fast = fast.next.next;    // Move fast pointer by two
            
            // If slow and fast pointers meet, there is a loop
            if (slow == fast) {
                // Step 2: Find the length of the loop
                return countLoopLength(slow);
            }
        }
        
        // No loop detected
        return 0;
    }

    // Helper function to count the number of nodes in the loop
    private int countLoopLength(Node meetingPoint) {
        int count = 1;
        Node current = meetingPoint;
        
        // Move through the loop until we reach the meeting point again
        while (current.next != meetingPoint) {
            count++;
            current = current.next;
        }
        
        return count;
    }
}
