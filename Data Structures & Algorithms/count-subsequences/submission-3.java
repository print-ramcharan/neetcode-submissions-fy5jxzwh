class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        dp = new int[n + 1][m + 1];
        
        for(int i = 0; i <= n; i ++){
            dp[i][m] = 1;
        }
        for(int j = 0; j < m; j ++){
            dp[n][j] = 1;
        }
        
        for(int i = n; i >= 0; i --){
            for(int j = m ; j >= 0; j --){
                
                if(j == m){
                    dp[i][j] = 1;
                    continue;
                }

                if(i == n){
                    dp[i][j] = 0;
                    continue;
                }
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i + 1][j] + dp[i + 1][j + 1];
                }else{
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        return dp[0][0];
    }
}
//   c a t
// c 1 3 1
// a
// a
// a
// t

//   x y
// x 3 2
// x
// y
// x
// y