class Solution {
    Node[] alternatingSplitList(Node head) {
        if (head == null) return new Node[]{null, null}; 

        Node a_head = null; 
        Node b_head = null; 
        Node a_tail = null; 
        Node b_tail = null; 
        Node current = head; 

        while (current != null) {
            if (a_head == null) {
                a_head = new Node(current.data);
                a_tail = a_head; 
            } else {
                a_tail.next = new Node(current.data);
                a_tail = a_tail.next; 
            }
            current = current.next;

            if (current != null) {
                if (b_head == null) {
                    b_head = new Node(current.data);
                    b_tail = b_head; 
                } else {
                    b_tail.next = new Node(current.data);
                    b_tail = b_tail.next; 
                }
                current = current.next;
            }
        }
        return new Node[]{a_head, b_head}; 
    }
}
