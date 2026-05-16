class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;


        return helper(nums, 0, -1);
    }

    private int helper(int[] nums, int i, int prevIdx){
        if(i == nums.length){
            return 0;
        }
        
        int notInclude = helper(nums, i + 1, prevIdx);
        
        int include = 0;
        if(prevIdx == -1 || nums[i] > nums[prevIdx]){
            include = 1 + helper(nums, i + 1, i);
        }
        
        return Math.max(notInclude, include);
    }
}
