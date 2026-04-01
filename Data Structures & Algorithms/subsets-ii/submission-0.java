class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }
    private void dfs(int nums[], int index, List<Integer> helper, List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<>(helper));
            return;
        }

        helper.add(nums[index]);
        dfs(nums, index + 1, helper, result);
        helper.remove(helper.size() - 1);
        int next = index + 1;
        while(next < nums.length && nums[next] == nums[index]){
            next ++;
        }
        dfs(nums, next, helper, result);
    }
}
