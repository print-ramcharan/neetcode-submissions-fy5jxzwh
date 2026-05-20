class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int totalSum = 0;

        for(int num : nums){
            totalSum += num;
        }

        if(totalSum % 2 != 0) return false;

        int target = totalSum / 2;

        Boolean[][] dp = new Boolean[n + 1][target + 1];

        return helper(nums, 0, target, dp);
    }

    private boolean helper(int[] nums, int i, int target, Boolean[][] dp){

        if(target == 0) return true;

        if(i == nums.length || target < 0) return false;

        if(dp[i][target] != null) return dp[i][target];

        boolean include = helper(nums, i + 1, target - nums[i], dp);

        boolean exclude = helper(nums, i + 1, target, dp);


        return dp[i][target] = include || exclude;
    }
}
