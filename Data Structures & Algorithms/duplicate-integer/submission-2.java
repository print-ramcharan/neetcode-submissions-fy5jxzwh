class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);

        for(int i = 1; i < nums.length; i ++){
            if(!set.contains(nums[i])) set.add(nums[i]);
            else return true;
        }
        return false;
    }
}