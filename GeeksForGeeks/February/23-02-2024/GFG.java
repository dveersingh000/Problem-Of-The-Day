class Solution 
{
    public static int maxProfit(int n, int[] price) 
    {
        // code here
        int first_buy = Integer.MIN_VALUE;
        int first_sell = 0;
        int second_buy = Integer.MIN_VALUE;
        int second_sell = 0;
       
        for(int i = 0; i < n; i++) 
        {
            first_buy = Math.max(first_buy, -price[i]); 
            first_sell = Math.max(first_sell, first_buy + price[i]); 
            second_buy = Math.max(second_buy, first_sell - price[i]);
            second_sell = Math.max(second_sell, second_buy + price[i]);
        }
        
        return second_sell;
    }
}