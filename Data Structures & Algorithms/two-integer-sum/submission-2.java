class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int i = 0;
        // for(int num : nums){
        //     map.put(i++, num);
        // }
        // for(i = 0; i < nums.length-1; i ++){
        //     int difference = target - nums[i];
        //     if(map.containValue(differece)) break;
        // }
        // return new int[]{i , map.};
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            int differnce = target - nums[i];
            if(map.containsKey(differnce)){
                return new int[] {map.get(differnce),i};
            }
            map.put(nums[i],i);
        }
        return new int[] {-1,-1};
    }
}
