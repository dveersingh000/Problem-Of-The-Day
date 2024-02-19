class Solution
{
    static int minValue(String s, int k)
    {
        // code here
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(char c:s.toCharArray())
            hm.put(c,hm.getOrDefault(c,0)+1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        
        for(Map.Entry<Character,Integer> e:hm.entrySet())
            pq.add(e.getValue());
        
        while(k!=0)
        {
            int freq = pq.remove();
            freq--;
            
            if(freq>0)
                pq.add(freq);
                
            k--;
        }
        
        int ans = 0;
        while(!pq.isEmpty())
        {
            int freq = pq.remove();
            ans = ans + (int)Math.pow(freq,2);
        }
        return ans;
    }
}