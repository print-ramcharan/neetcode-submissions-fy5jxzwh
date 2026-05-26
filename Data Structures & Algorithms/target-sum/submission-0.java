class Solution {
    int target;
    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;

        return dfs(nums, 0, 0);
    }       


    private int dfs(int[] nums, int currTarget, int i){
        int n = nums.length;

        
        if(i == n) return currTarget == target ? 1 : 0;
        


        int add = dfs(nums, currTarget + nums[i], i + 1);

        int sub = dfs(nums, currTarget - nums[i], i + 1);

        return add + sub;
    }
}
