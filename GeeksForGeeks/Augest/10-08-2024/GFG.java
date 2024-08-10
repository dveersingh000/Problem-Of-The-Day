class Solution {
    public Node rotate(Node head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        for (int i = 1; i <= k; i++) {
            Node t = head;
            head = head.next;
            t.next = null;
            p.next = t;
            p = t;
        }
        return head;
    }
}
