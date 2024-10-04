class Solution {
    // Function to reverse a circular linked list
    Node reverse(Node head) {
        // code here
         if (head == null || head.next == head) return head; // empty or single node list
        
        Node prev = null;
        Node curr = head;
        Node next = null;
        
        // Traverse the entire circular linked list and reverse the pointers
        do {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } while (curr != head);
        
        // Adjust head's next to the previous node to make it circular again
        head.next = prev;
        head = prev; // Update the head
        
        return head;
    }

    // Function to delete a node from the circular linked list
    Node deleteNode(Node head, int key) {
        // code here
         if (head == null) return null;
        
        Node curr = head;
        Node prev = null;
        
        // Case 1: If head contains the key
        if (head.data == key) {
            // Find the last node in the circular list
            while (curr.next != head) {
                curr = curr.next;
            }
            // If the list has only one node
            if (head == head.next) {
                return null; // return null for an empty list after deletion
            }
            // Adjust the pointers to remove the head and set new head
            curr.next = head.next;
            head = head.next;
            return head;
        }
        
        // Case 2: If key is present somewhere other than head
        curr = head;
        do {
            prev = curr;
            curr = curr.next;
            if (curr.data == key) {
                prev.next = curr.next;
                return head; // head remains the same
            }
        } while (curr != head);
        
        // If key is not found, return the original list
        return head;
    }
}
