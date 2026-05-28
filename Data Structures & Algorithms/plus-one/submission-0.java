class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        if(digits[n - 1] == 9){
            int[] res = new int[n + 1];
            res[0] = 1;
            // for(int i = 1; i < n; i ++){
            //     res[i] = digits[i];
            // }
            return res;
        }

        digits[n - 1] ++;

        return digits;
    }
}
