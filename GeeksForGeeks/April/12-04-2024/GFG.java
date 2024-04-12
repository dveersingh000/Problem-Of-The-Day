class Solution 
{
    static long pairAndSum(int n, long arr[]) 
    {
        // code here
        long ans = 0;
        for(int i = 0; i < 32; i++) 
        {
            long count = 0;
            
            for(int j = 0; j < n; j++) 
                count += (arr[j] >> i) & 1;
        
            ans += (1L << i) * (count * (count - 1) / 2);
        }
        
        return ans;
    }
}
