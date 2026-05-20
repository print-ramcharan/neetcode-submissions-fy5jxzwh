class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int totalSum = 0;

        for(int num : nums){
            totalSum += num;
        }

        if(totalSum % 2 != 0) return false;

        int target = totalSum / 2;

        boolean[][] dp = new boolean[n + 1][target + 1];

        for(int i = 0; i <= n; i ++){
            dp[i][0] = true;
        }

        for(int i = n - 1; i >= 0; i --){
            for(int j = 1; j <= target; j ++){
                boolean exclude = dp[i + 1][j];

                boolean include = false;
                if(j >= nums[i]){
                    include = dp[i + 1][j - nums[i]];
                }
                dp[i][j] = include || exclude;
            }
        }

        return dp[0][target];
    }
}
