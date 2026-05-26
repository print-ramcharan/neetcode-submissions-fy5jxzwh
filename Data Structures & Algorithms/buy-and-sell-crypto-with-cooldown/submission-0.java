class Solution {
    private int[][] memo;

    public int maxProfit(int[] prices) {
        int n = prices.length;

        memo = new int[n][2];

        for(int[] row : memo){
            Arrays.fill(row, - 1);
        }

        return dfs(prices, 0, 1);
    }

    private int dfs(int[] prices, int i, int canBuy){

        if(i >= prices.length) return 0;

        int profit = 0;


        if(canBuy == 1){
            int skip = dfs(prices, i + 1, 1);

            int buy = -prices[i] + dfs(prices, i + 1, 0);

            profit = Math.max(skip, buy);
        }else{
            int skip = dfs(prices, i + 1, 0);

            int sell = prices[i] + dfs(prices, i + 2, 1);

            profit = Math.max(skip, sell);
        }

        return memo[i][canBuy] = profit;
    }
}
