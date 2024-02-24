class Solution
{
    public int fn(int n)
    {
        int a=n/2, b=n/3, c=n/4;
        
        if(a+b+c>n)
            return fn(a)+fn(b)+fn(c);
        
        else
            return n;
    }
    
    public int maxSum(int n) 
    { 
        return fn(n);
    }
}