class Solution {
    int getMiddle(Node head) {
        // Your code here.
         if (head == null) {
            return -1;
        }

        // Initialize slow and fast pointers
        Node slow = head;
        Node fast = head;

        // Traverse the list
        while (fast != null && fast.next != null) {
            slow = slow.next;       // move slow by 1 step
            fast = fast.next.next;  // move fast by 2 steps
        }

        // Slow is now pointing to the middle node
        return slow.data;
    }
}
