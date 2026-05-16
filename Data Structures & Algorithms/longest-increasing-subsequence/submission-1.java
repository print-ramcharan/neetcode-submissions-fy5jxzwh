class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        dp = new int[n + 1][n + 1];

        for(int[] row : dp){
            Arrays.fill(row, - 1);
        }
        return helper(nums, 0, -1);
    }

    private int helper(int[] nums, int i, int prevIdx){
        if(i == nums.length){
            return 0;
        }
        
        if(dp[i][prevIdx + 1] != -1) return dp[i][prevIdx + 1];
        int notInclude = helper(nums, i + 1, prevIdx);
        
        int include = 0;
        if(prevIdx == -1 || nums[i] > nums[prevIdx]){
            include = 1 + helper(nums, i + 1, i);
        }
        
        return dp[i][prevIdx + 1] = Math.max(notInclude, include);
    }
}
