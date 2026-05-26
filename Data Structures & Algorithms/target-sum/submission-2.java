class Solution {

    private Map<String, Integer> memo;

    public int findTargetSumWays(int[] nums, int target) {
        
        memo = new HashMap<>();

        return dfs(nums, 0, 0, target);
    }       


    private int dfs(int[] nums, int currTarget, int i, int target){
        int n = nums.length;

        if(i == n) return currTarget == target ? 1 : 0;

        String key = i + "," + currTarget;

        
        if(memo.containsKey(key)) return memo.get(key);

        int add = dfs(nums, currTarget + nums[i], i + 1, target);

        int sub = dfs(nums, currTarget - nums[i], i + 1, target);

        memo.put(key, add + sub);
        return add + sub;
    }
}
