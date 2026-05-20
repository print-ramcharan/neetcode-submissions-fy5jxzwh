class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int totalSum = 0;

        for(int num : nums){
            totalSum += num;
        }

        if(totalSum % 2 != 0) return false;

        int target = totalSum / 2;

        return helper(nums, 0, target);
    }

    private boolean helper(int[] nums, int i, int target){

        if(target == 0) return true;

        if(i == nums.length || target < 0) return false;

        boolean include = helper(nums, i + 1, target - nums[i]);

        boolean exclude = helper(nums, i + 1, target);


        return include || exclude;
    }
}
