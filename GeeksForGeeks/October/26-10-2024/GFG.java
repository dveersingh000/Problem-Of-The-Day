class Solution {
    public int count(Node head, int key) {
        int count = 0;
        Node current = head;
        while (current != null) {
            count += (current.data == key) ? 1 : 0;
            current = current.next;
        }
        return count;
    }
}
