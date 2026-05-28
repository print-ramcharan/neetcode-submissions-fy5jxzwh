class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();


        while(n != 1 && !set.contains(n)){
            set.add(n);

            int temp = 0;
            int current = n;

            while(current > 0){
                int dig = current % 10;
                temp += dig * dig;
                current /= 10;
            }
            
            n = temp;
        }
        return n == 1;
    }
}
