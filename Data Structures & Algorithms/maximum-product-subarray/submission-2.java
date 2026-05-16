class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int globalMax = nums[0];

        for(int i = 1; i < nums.length; i ++){
            int current = nums[i];

            int choice1 = current;
            int choice2 = current * maxSoFar;
            int choice3 = current * minSoFar;

            maxSoFar = Math.max(choice1, Math.max(choice2, choice3));
            minSoFar = Math.min(choice1, Math.min(choice2, choice3));

            globalMax = Math.max(maxSoFar, globalMax);    
        }

        return globalMax;
    }
}
