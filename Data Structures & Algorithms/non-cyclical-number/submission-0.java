class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();


        while(!set.contains(n)){
            int temp = 0;

            while(n > 0){
                int dig = n % 10;
                temp += dig * dig;
                n /= 10;
            }
            set.add(temp);
            n = temp;
            if(n == 1) return true;
        }
        return false;
    }
}
