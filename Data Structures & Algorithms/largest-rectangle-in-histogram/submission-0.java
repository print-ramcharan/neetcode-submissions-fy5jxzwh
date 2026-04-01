class Solution {
    public int largestRectangleArea(int[] heights) {
       int l = 0; 
       int r = 0;
       int size = heights.length;
       int maxArea = 0;
       for(int i = 0 ; i < size; i++){
            r=i;
            l=i;
             while( l-1 >= 0 && heights[i] <= heights[l-1]){
                l--;
             }
             while( r+1 <size &&heights[i] <= heights[r+1]){
                r++;
             }
           int area = r - l + 1;
           int tempArea = heights[i]* area;
            maxArea = max(tempArea, maxArea);
        }

       
       
       return maxArea;
    }
    public int max(int a , int b){
        return a>b? a : b;
    }
     public int min(int a , int b){
        return a<b? a : b;
    }
}
