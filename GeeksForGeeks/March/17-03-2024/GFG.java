class Solution {

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) 
    {
        // add your code here
        int count = 0;
          
        Collections.sort(head1);
        Collections.sort(head2,Collections.reverseOrder());
         
        Iterator<Integer> itr1 = head1.iterator();
        Iterator<Integer> itr2 = head2.iterator();
         
        Integer num1 = itr1.hasNext() ? itr1.next() : null;
        Integer num2 = itr2.hasNext() ? itr2.next() : null;
         
        while(num1 != null && num2 != null)
        {     
            if ((num1 + num2) == x)
            {
                num1 = itr1.hasNext() ? itr1.next() : null;
                num2 = itr2.hasNext() ? itr2.next() : null;
                 
                count++; 
            } 
             
            else if ((num1 + num2) > x)
                num2 = itr2.hasNext() ? itr2.next() : null;
             
            else
                num1 = itr1.hasNext() ? itr1.next() : null;
             
        }
                            
        return count;
    }
}
