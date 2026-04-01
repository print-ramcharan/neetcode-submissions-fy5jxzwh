class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int A [] =nums1;
        int B[] = nums2;
        if (A.length > B.length) {
        A = nums2;
        B = nums1;
        }
        int x = A.length;
        int y = B.length;
        int total = x + y;
        int half = total / 2;

        int l = 0, r = x;

        while(l<=r){
            int i = l+ (r-l)/2;
            int j = half - i ;

           int Aleft = (i > 0) ? A[i - 1] : Integer.MIN_VALUE; 
            int Aright = (i < x) ? A[i] : Integer.MAX_VALUE;    
             int Bleft = (j > 0) ? B[j - 1] : Integer.MIN_VALUE; 
            int Bright = (j < y) ? B[j] : Integer.MAX_VALUE;  
           if(Aleft <= Bright && Bleft <= Aright ){
            if(total%2 == 0){
                 return (double)(Math.max(Aleft,Bleft)+Math.min(Aright,Bright) )/2;
            }else{
                 return Math.min(Aright,Bright);
            }
           }else if(Aleft > Bright){
            r = i -1;
           }else{
            l = i+1;
           }
            
        }
        return -1;
    }
}
