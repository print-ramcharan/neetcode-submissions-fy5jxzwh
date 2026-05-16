class Solution {
    public int maxProduct(int[] nums) {
        
        int[] globalMax = {nums[0]};
        helper(nums, 0, globalMax);

        return globalMax[0];
    }

    private int[] helper(int[] nums, int i, int[] globalMax){
        if(i == nums.length){
            return new int[] {1, 1};
        }

        int[] nextResults = helper(nums, i + 1, globalMax);

        int nextMax = nextResults[0];
        int nextMin = nextResults[1];

        int choice1 = nums[i];
        int choice2 = nums[i] * nextMax;
        int choice3 = nums[i] * nextMin;

        int localMax = Math.max(choice1, Math.max(choice2, choice3));
        int localMin = Math.max(choice1, Math.max(choice2, choice3));

        globalMax[0] = Math.max(globalMax[0], localMax);

        return new int[]{localMax, localMin};
    }
}
