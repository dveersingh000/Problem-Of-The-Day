class Geeks {
    public long count(int n) 
    {
        // Add your code here.
        int[] ways = new int[n + 1];
 
        ways[0] = 1;
 
        int[] moves = { 3, 5, 10 };
        
        for (int i = 0; i < 3; i++)
            for (int j = moves[i]; j <= n; j++)
                ways[j] += ways[j - moves[i]];
 
        return ways[n];
    }
}