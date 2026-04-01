class Solution {
    public int trap(int[] height) {
        int trappedWater =0;
        int l = 0, r= height.length-1;
        int leftMax = height[l], rightMax = height[r];

        while(l<r){
            if(leftMax < rightMax){
                l++;
                leftMax = max(leftMax,height[l]);
                trappedWater += leftMax - height[l];
            }else{
                r--;
                rightMax = max(rightMax,height[r]);
                trappedWater += rightMax - height[r];
            }
           

        }
        return trappedWater;
    }
    public int max(int a, int b){
        return a>b? a:b;
    }
    public int min(int a, int b){
        return a<b? a:b;
    }
}
