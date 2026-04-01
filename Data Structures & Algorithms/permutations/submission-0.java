class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // if(nums.length == 0) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res);
        return res;
    }
    private void backtrack(int[] nums, int start, List<List<Integer>> result){
        if(start == nums.length ){
            List<Integer> perm = new ArrayList<>();
            for(int num : nums) perm.add(num);
            result.add(perm);
            return;
        }
        for(int i = start; i < nums.length; i ++){
            swap(nums, i, start);
            backtrack(nums, start + 1, result);
            swap(nums, i, start);
        }
    }
    private void swap(int[] nums, int index, int start){
        int temp = nums[index];
        nums[index] = nums[start];
        nums[start] = temp;
    }
}
