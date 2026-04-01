class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      int res[] = new int[nums.length-k+1];
      int index = 0;
      int l = 0; 
      int r = 0;
    //   for(int j=0; j< res.length;j++){
      
    //         for(int i = j; i<r; i++){
    //             if(nums[i]>nums[i+1] && i+1<r){
    //             max = nums[i];
    //             }else if( i+1 == r){
    //             res[l]=max;
    //             l++;
                
            
    //             }
    //         }
    //   }
      while( r<nums.length){
        if(r-l +1== k ){
             int max = Integer.MIN_VALUE;
             for(int i = l; i<=r; i++){
                max = max(max,nums[i]);
                
               
                    
            }
            res[index++]=max;
            l++;
         
        }
        r++;
       
      }
    //   for(r = k ; r<nums.length; r++){
    //     l++;
    //     if(nums[r]>){
    //         max=nums[r];
    //     }
    //     res[l]=max;
    //     l++;

    //   }
      return res;
    }
    public int max(int a , int b){
        return a>b? a:b;
    }
}
