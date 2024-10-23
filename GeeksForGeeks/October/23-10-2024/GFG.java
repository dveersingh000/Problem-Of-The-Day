class Solution {
    public int sumOfLastN_Nodes(Node head, int n) {
        if (n <= 0 || head == null) return 0;

        Node fast = head;
        Node slow = head;

        for (int i = 0; i < n; i++) {
            if (fast == null) return 0;
            fast = fast.next;
        }

        int sum = 0;

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        while (slow != null) {
            sum += slow.data;
            slow = slow.next;
        }

        return sum;
    }
}
