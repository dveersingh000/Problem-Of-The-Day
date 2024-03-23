class Solution {
    int[] Series(int n) {
        int MOD = 1000000007;
        int[] ans = new int[n + 1];
        if (n == 0) return ans; 
        
        int prev = 0, cur = 1;
        ans[0] = prev;
        ans[1] = cur;
        
        for (int i = 2; i <= n; ++i) {
            int next = (prev + cur) % MOD;
            ans[i] = next;
            prev = cur;
            cur = next;
        }
        
        return ans;
    }

}
