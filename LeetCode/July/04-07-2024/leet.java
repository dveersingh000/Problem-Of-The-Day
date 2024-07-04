class Solution {
    public ListNode mergeNodes(ListNode head) {
       ListNode P1 = head.next; 
        ListNode current = P1; 

        while (P1 != null) {
            int sum = 0;
           
            while (P1 != null && P1.val != 0) {
                sum += P1.val;
                P1 = P1.next;
            }

            // Move P1 to the next zero node (if it exists)
            if (P1 != null) {
                P1 = P1.next;
            }

            // Create a new node with the sum and attach it to the result list
            current.next = new ListNode(sum);
            current = current.next;
        }
        return head.next.next;
    }
}
