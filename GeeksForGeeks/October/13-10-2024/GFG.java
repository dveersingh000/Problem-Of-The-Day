class Solution {
    public void deleteAlt(Node head) {
        if (head == null) {
            return;
        }

        Node current = head;

        while (current != null && current.next != null) {
            // Skip the next node
            current.next = current.next.next;
            // Move to the next node in the updated list
            current = current.next;
        }
    }
}
