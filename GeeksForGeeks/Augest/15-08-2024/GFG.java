class Solution {
    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public Node addOne(Node head) {
        // code here.
        head = reverse(head);

        // Add 1 to the reversed list
        Node current = head;
        int carry = 1;
        Node prev = null;

        while (current != null) {
            int sum = current.data + carry;
            carry = sum / 10;
            current.data = sum % 10;
            prev = current;
            current = current.next;
        }

        // If there is still a carry left, add a new node
        if (carry > 0) {
            prev.next = new Node(carry);
        }

        // Reverse the list again to restore the original order
        return reverse(head);
    }
}
