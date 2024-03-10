class Solution 
{
    String removeDuplicates(String str) 
    {
        Map<Character,Integer> exists = new HashMap<>();
 
        String ans = "";
        for(int i = 0; i < str.length(); i++)
        {
            if(!exists.containsKey(str.charAt(i)))
            {
                ans += str.charAt(i);
                exists.put(str.charAt(i), 1);
            }
        }
        
        return ans;
    }
}