class Solution 
{
    public boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) 
    {
        // Code here
        for(ArrayList<Integer> ad : adj)
            if(ad.size()%2!=0)
                return false;
        
        return true;
    }
}
