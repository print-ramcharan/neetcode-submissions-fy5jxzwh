class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        int l = 0, r = n - 1;

        while(l <= r){
            
            int curSum = numbers[l] + numbers[r];

            if(curSum > target){
                r--;
            }else if(curSum < target){
                l++;
            }else{
                return new int[]{ l + 1, r + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
