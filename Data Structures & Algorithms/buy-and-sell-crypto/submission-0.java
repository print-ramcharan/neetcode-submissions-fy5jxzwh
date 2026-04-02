class Solution {
    public int maxProfit(int[] prices) {
       int l = 0, r = prices.length-1;
       int profit = 0;
       while(l<r){
            int temp = prices[r]-prices[l];
            profit = max(temp,profit);
         if(prices[l]> prices[r]){
            l++;
         }else{
            r--;
         }
         
       }
       return profit;

    }
    public int max(int a, int b){
        return a>b? a : b;
    }
}
