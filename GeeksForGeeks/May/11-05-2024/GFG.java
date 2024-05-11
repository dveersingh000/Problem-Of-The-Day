class Solution 
{
    static List<Long> jugglerSequence(long n) 
    {
        // code here
        List<Long> ans=new ArrayList<>();
        ans.add(n);
        while(n>1)
        {
            if(n%2==0)
                n=(long)Math.pow(n,0.5);
            else
                n=(long)Math.pow(n,1.5);
           
            ans.add(n);
        }
        
        return ans;
    }
}
