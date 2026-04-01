class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums.length == 0) return false;
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);

        for(int i = 1; i < nums.length; i ++){
            if(!set.contains(nums[i])) set.add(nums[i]);
            else return true;
        }
        return false;
    }
}