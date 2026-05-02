class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        dfs(res, new ArrayList<>(), nums, 0, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> curList, int[] nums, int index, int sum){
        
        if((curList.size() == 3) && sum == 0){
            res.add(new ArrayList<>(curList));
            return;
        }

        if(index >= nums.length) return;
        
        curList.add(nums[index]);
        dfs(res, curList, nums, index + 1, sum + nums[index]);
        curList.remove(curList.size() - 1);
        while(index + 1 < nums.length && nums[index] == nums[index + 1]){
            index ++;
        }
        dfs(res, curList, nums, index + 1, sum);
    }
}
