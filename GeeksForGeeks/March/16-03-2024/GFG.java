class Solution
{
    void deleteNode(Node del_node)
    {
         // Your code here
        if(del_node == null)
            return; 
        else
            if(del_node.next == null)
                return;
    
        del_node.data = del_node.next.data; 
  
        del_node.next = del_node.next.next;
    }
}
