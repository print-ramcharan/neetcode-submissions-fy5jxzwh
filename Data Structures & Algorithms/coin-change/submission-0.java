class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int length = coins.length;
        int sol = 0;
        int count = 0;
        if (amount == 0) return 0;
        for(int i = length - 1; i >= 0; ){

            if(sol == amount) return count;
            else if(sol < amount){
                if((sol + coins[i]) <= amount){
                    sol += coins[i];
                    count ++;
                    
                }else{
                    i --;
                }
            }
        }
        return -1;
    }
}
