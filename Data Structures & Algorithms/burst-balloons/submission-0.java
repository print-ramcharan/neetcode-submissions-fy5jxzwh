class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] padded = new int[n + 2];
        padded[0] = 1;
        padded[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            padded[i + 1] = nums[i];
        }

        int[][] memo = new int[n + 2][n + 2];
        return breakthrough(padded, 1, n, memo);
    }

    private int breakthrough(int[] nums, int left, int right, int[][] memo) {
        if (left > right) {
            return 0;
        }

        if (memo[left][right] != 0) {
            return memo[left][right];
        }

        int maxCoins = 0;

        for (int i = left; i <= right; i++) {
            int coins = nums[left - 1] * nums[i] * nums[right + 1];
            int total = coins + breakthrough(nums, left, i - 1, memo) + breakthrough(nums, i + 1, right, memo);
            maxCoins = Math.max(maxCoins, total);
        }

        memo[left][right] = maxCoins;
        return maxCoins;
    }
}