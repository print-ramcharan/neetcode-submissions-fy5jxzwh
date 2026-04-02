class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] != nums[nums[i]-1]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
          
            if(nums[i]== nums[i+1]){
            return nums[i];
            } 
        }
        return -1;
    }
}
