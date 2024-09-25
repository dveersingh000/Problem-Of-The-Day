class Solution {
    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        // Your code here
        if (head == null || head.next == null) {
            return true; // A single node or empty list is a palindrome
        }

        // Step 1: Find the middle of the linked list
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // move slow by 1
            fast = fast.next.next; // move fast by 2
        }

        // Step 2: Reverse the second half of the list starting from 'slow'
        Node secondHalf = reverseList(slow);
        Node reverseHead = secondHalf; // Keep track of reversed half head to restore later

        // Step 3: Compare the first half and the reversed second half
        Node firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false; // If mismatch found, not a palindrome
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // (Optional) Step 4: Restore the original list (if needed)
        reverseList(reverseHead);

        return true; // All nodes matched, it's a palindrome
    }

    // Helper function to reverse a linked list
    private Node reverseList(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
