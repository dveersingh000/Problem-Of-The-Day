class Node {
    int data;
    Node next, random;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    // Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        if (head == null) return null;
        
        // Step 1: Clone the nodes and place them next to the original nodes
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Step 2: Set up the random pointers for the cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next; // Move to the next original node
        }

        // Step 3: Restore the original list and extract the cloned list
        Node original = head;
        Node copy = head.next;
        Node copyHead = copy;

        while (original != null) {
            original.next = original.next.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            original = original.next;
            copy = copy.next;
        }

        return copyHead;
    }
}
