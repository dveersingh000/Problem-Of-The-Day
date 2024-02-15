class Solution
{
    public int isPossible(int[][] paths)
    {
        // Code here
        for(int i=0;i<paths.length;i++)
        {
            int cnt = 0;
            
            for(int j=0;j<paths[0].length;j++)
            {
                cnt+=paths[i][j];
            }
            
            if(cnt%2!=0)
            {
                return 0;
            }
        }
        return 1;
    }
}