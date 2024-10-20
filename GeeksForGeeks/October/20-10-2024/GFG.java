class Solution {
    public DLLNode sortAKSortedDLL(DLLNode head, int k) {
        if (head == null) return null;

        PriorityQueue<DLLNode> pq = new PriorityQueue<>(new Comparator<DLLNode>() {
            public int compare(DLLNode a, DLLNode b) {
                return a.data - b.data;
            }
        });

        DLLNode newHead = null, last = null;
        
        for (int i = 0; head != null && i <= k; i++) {
            pq.add(head);
            head = head.next;
        }

        while (!pq.isEmpty()) {
            if (newHead == null) {
                newHead = pq.poll();
                newHead.prev = null;
                last = newHead;
            } else {
                last.next = pq.poll();
                last.next.prev = last;
                last = last.next;
            }

            if (head != null) {
                pq.add(head);
                head = head.next;
            }
        }

        last.next = null;
        return newHead;
    }
}
