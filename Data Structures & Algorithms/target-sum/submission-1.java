class Solution {
    int target;
    int[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;
        dp = new int[nums.length][target + 1];

        return dfs(nums, 0, 0);
    }       


    private int dfs(int[] nums, int currTarget, int i){
        int n = nums.length;

        if(i == n) return currTarget == target ? 1 : 0;

        if(dp[i][currTarget] != -1) return dp[i][currTarget];
        int add = dfs(nums, currTarget + nums[i], i + 1);

        int sub = dfs(nums, currTarget - nums[i], i + 1);

        return dp[i][currTarget] = add + sub;
    }
}
