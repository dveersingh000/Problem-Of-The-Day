class Solution {
public:
    Node* reverse(Node* head) {
        Node* prev = nullptr;
        Node* curr = head;
        while (curr) {
            Node* next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    void sort(Node **head)
    {
        if (!(*head) || !(*head)->next)
            return;

        Node *asc = (*head), *des= (*head)->next;
        Node* revStart = des;
        
        while (des && des->next) {
            asc->next = des->next;
            asc = asc->next;
            des->next = asc->next;
            des = des->next;
        }
        
        Node* temp = reverse(revStart);
        asc->next = temp;
    }
};
