class Solution
{
    public char nthCharacter(String s, int r, int n)
    {
        //code here
        while(r-- > 0) 
        {
            String m = "";
            for(int i = 0; i < Math.min(s.length(),n+1); i++) 
            {
                if(s.charAt(i) == '1')
                    m+="10";
                else
                    m+="01";
            }
            
            s = m;
        }
        
        return s.charAt(n);
    }
}