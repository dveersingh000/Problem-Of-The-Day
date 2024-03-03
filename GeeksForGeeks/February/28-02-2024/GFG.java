class Solution{
    int DivisibleByEight(String s)
    {
        //code here
        if ( s.length() >= 3 ) 
        {
            String last3 = s.substring( s.length()-3 );
            int val = Integer.parseInt(last3);
        
            return ( val == 0 || val % 8 == 0 ) ? 1 : -1 ;
        }
        
        int v = Integer.parseInt(s);
        return ( v == 0 || v % 8 == 0 ) ? 1 : -1 ;
    }
}