class Solution {
    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        temp.npx = head;
        head = temp;
        return head;
    }

    static ArrayList<Integer> getList(Node head) {
        ArrayList<Integer> ans = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            ans.add(temp.data);
            temp = temp.npx;
        }
        return ans;
    }
}
