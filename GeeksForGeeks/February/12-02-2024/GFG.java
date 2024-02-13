class Solution{
    static long sequence(int n)
    {
        long mod=1000000007;
        return func(n,1,0,1)%mod;
    }
    
    static long func(int n, int iterations, long sum , int start)
    {
        if(n==0)
        {
            return sum;
        }
        
        int it = iterations;
        
        long pro=1, mod=1000000007;
        
        while(it>0)
        {
            pro=pro*start;
            pro%=mod;
            start++;
            it--;
        }
        
        sum+=pro;
        
        return func(n-1,iterations+1,sum,start); 
    }
}