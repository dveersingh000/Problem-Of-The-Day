class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        int n = s.length();
        ArrayList<String>res=new ArrayList<>();
        
        for (int m = 0; m < (1 << n); m++) 
        {
           String sb = "";
           for (int i = 0; i < n; i++) 
            {
                if ((m & (1 << i))!=0)
                    sb += s.charAt(i);
            }
            
            if (sb.length() > 0)
                res.add(sb);
        }
        
        Collections.sort(res);
        return res;
    }
}