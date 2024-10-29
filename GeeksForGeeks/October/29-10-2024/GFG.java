class GfG {
    private Node split(Node head) {
        Node slow = head, fast = head, prev = null;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (prev != null) {
            prev.next = null;
        }
        
        return slow;
    }

    private Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        if (left.data < right.data) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }

    private Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;

        Node mid = split(head);
        Node left = mergeSort(head);
        Node right = mergeSort(mid);

        return merge(left, right);
    }

    public Node quickSort(Node head) {
        return mergeSort(head);
    }
}
