class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        int maxLen = 0;

        Set<String> set = new HashSet<>();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(String word : wordDict){
            set.add(word);
            maxLen = Math.max(maxLen, word.length());
        }

        for(int i = 1; i <= n; i ++){
            int start = Math.max(0, i - maxLen);
            for(int j = i - 1; j >= start; j --){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
