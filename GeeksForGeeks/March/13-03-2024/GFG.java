class Solution 
{
    public int[] matrixDiagonally(int[][] mat) 
    {
        int n = mat.length, mode = 0, it = 0, lower = 0; 
        ArrayList<Integer> arr = new ArrayList<>();
  
        for (int t = 0; t < (2 * n - 1); t++) 
        { 
            int t1 = t; 
            if (t1 >= n) 
            { 
                mode++; 
                t1 = n - 1; 
                it--; 
                lower++; 
            } 
            else 
            { 
                lower = 0; 
                it++; 
            } 
            
            for (int i = t1; i >= lower; i--) 
            { 
                if ((t1 + mode) % 2 == 0) 
                { 
                    arr.add(mat[i][t1 + lower - i]);
                } 
                else
                { 
                    arr.add(mat[t1 + lower - i][i]); 
                } 
            } 
        }
        
        return arr.stream().mapToInt(i -> i).toArray();
    }
}