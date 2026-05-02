class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        int l = 0, r = n - 1;

        while(l <= r){
            int mid = l + r / 2;

            if(numbers[l] + numbers[r] == target) return new int[]{ l + 1, r + 1};
            int diff = target - numbers[mid];

            if(diff > numbers[mid]){
                l = mid;
            }else{
                r = mid;
            }
        }
        return new int[]{-1, -1};
    }
}
