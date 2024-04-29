class Solution
{
    /*You are required to complete this method*/
    Node delete(Node head, int k)
    {
	    // Your code here	 
	    Node prev = new Node(-1);
	    Node temp = prev;
	    prev.next = head;
	    int cnt = 1;
	    while(temp.next!=null)
	    {
	        if(cnt==k)
	        {
	            temp.next = temp.next.next;
	            cnt = 0;
	        }
	        else
	        {
	            temp = temp.next;
	        }
	        cnt++;
	    }
	    
	    return prev.next;
    }
}
