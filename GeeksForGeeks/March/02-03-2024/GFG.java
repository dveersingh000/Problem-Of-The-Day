import java.util.HashMap;

class Solution
{
    public int firstElementKTime(int n, int k, int[] a) 
    { 
        HashMap<Integer, Integer> count_map = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            count_map.put(a[i], count_map.getOrDefault(a[i], 0) + 1);
            if (count_map.get(a[i]) == k) 
            {
                return a[i];
            }
        }
 
        return -1;
    } 
}