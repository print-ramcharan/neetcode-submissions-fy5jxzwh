class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> idx = new HashMap<>();
        
        for(int i =0 ; i< nums.length; i++){
            idx.put(nums[i],i);
            if(idx.containsKey(target-nums[i])&& i!=idx.get(target-nums[i])){
                int[] retn =new int[2];
               retn[0]= idx.get(target-nums[i]);
               retn[1]= i;
               return retn;
            }
        }
        return new int[0];
        
    }
}
