class Solution {
    public double myPow(double x, int n) {
        long N = n;

        if(N < 0){
            x = 1 / x;
            N = - N;
        }

        double res = 1.0;
        double currentProduct = x;

        while(N > 0){
            if((N & 1) == 1){
                res = res * currentProduct;
            }
            currentProduct = currentProduct * currentProduct;
            N = N >> 1;
        }

        return res; 
        
    }
}
