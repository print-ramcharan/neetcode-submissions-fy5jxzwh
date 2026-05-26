class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount + 1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return dfs(amount, coins, 0);
    }

    private int dfs(int target, int[] coins, int i){

        if(target == 0) return 1;

        
        if(target < 0 || i >= coins.length) return 0;
       
        if(dp[i][target] != -1) return dp[i][target];

        int take = dfs(target - coins[i], coins, i);

        int skip = dfs(target, coins, i + 1);
        
        return dp[i][target] = take + skip;

    }
}
