class Solution {
    public int wordBreak(int n, String s, List<String> dictionary) {
        int ns = s.length();

        boolean[] dp = new boolean[ns + 1];
        dp[0] = true;

        for (int i = 0; i < ns; i++) {
            if (!dp[i]) continue;

            StringBuilder ss = new StringBuilder();
            for (int j = i; j < ns; j++) {
                ss.append(s.charAt(j));
                for (String word : dictionary) {
                    if (ss.toString().equals(word)) {
                        dp[j + 1] = true;
                        break;
                    }
                }
            }
        }
        return dp[ns] ? 1 : 0;
    }
}