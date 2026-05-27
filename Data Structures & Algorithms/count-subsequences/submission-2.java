class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];
        
        for(int[] row : dp){
            Arrays.fill(row, -1);

        }
        return dfs(s, t, 0, 0, new boolean[s.length()]);
    }

    private int dfs(String s, String t, int i, int j, boolean[] picked){

        int n = s.length();

        
        if(j == t.length()) return 1;

        if(i == n || picked[i]) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int notPick = 0;
        int pick = 0;
        int dontPick = 0;
        if(s.charAt(i) == t.charAt(j)){
            picked[i] = true;
            pick = dfs(s, t, i + 1, j + 1, picked);
            picked[i] = false;

            dontPick = dfs(s, t, i + 1, j, picked);


               
        }else{
            notPick = dfs(s, t, i + 1, j, picked); 
        }

        return dp[i][j] = notPick + pick + dontPick;
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