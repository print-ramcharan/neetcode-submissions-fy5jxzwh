class Solution {
    public boolean hasDuplicate(int[] nums) {
       Set<Integer> numsx = new HashSet<>();
       for(int num : nums){
        if(numsx.contains(num)){
            return true;
        }
        numsx.add(num);
       }
       return false;
    }
}
