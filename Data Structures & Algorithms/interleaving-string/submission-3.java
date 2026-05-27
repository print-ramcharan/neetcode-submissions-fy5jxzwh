class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        
        int n = s1.length();
        int m = s2.length();
        
        if (n + m != s3.length()) {
            return false;
        }
        
        boolean[] dp = new boolean[m + 1];

        for(int i = n; i >= 0; i --){
            for(int j = m; j >= 0; j --){
                if(i == n && j == m){
                    dp[j] = true;
                }else if(i == n){
                    dp[j] = dp[j + 1] && s2.charAt(j) == s3.charAt(i + j);
                }else if(j == m){
                    dp[j] = dp[j] && s1.charAt(i) == s3.charAt(i + j);
                }else{
                    boolean fromS1 = s1.charAt(i) == s3.charAt(i + j) && dp[j];
                    boolean fromS2 = s2.charAt(j) == s3.charAt(i + j) && dp[j + 1];

                    dp[j] = fromS1 || fromS2;
                }
            }
        }

        return dp[0];
    }
}