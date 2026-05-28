class Solution {
    public boolean isHappy(int n) {
        int tortoise = n;
        int hare = getNextSum(n);

        while(hare != 1 && tortoise != hare){
            tortoise = getNextSum(tortoise);
            hare = getNextSum(getNextSum(hare));
        }

        return hare == 1;
    }

    private int getNextSum(int n){
        int temp = 0;

        while(n > 0){
            int dig = n % 10;
            temp += dig * dig;
            n /= 10;
        }

        return temp;
    }
}
