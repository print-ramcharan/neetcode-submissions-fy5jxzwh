class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        dp = new int[n + 1][n + 1];

        for(int i = n - 1; i >= 0; i --){

            for(int prevIdx = i - 1; prevIdx >= -1; prevIdx --){

                int notInclude = dp[i + 1][prevIdx + 1];

                int include = 0;

                if(prevIdx == -1 || nums[i] > nums[prevIdx]){
                    include = 1 + dp[i + 1][i + 1];
                }

                dp[i][prevIdx + 1] = Math.max(include, notInclude);
            }
        }
        return dp[0][0];
    }
}
