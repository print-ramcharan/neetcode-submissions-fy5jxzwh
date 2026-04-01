class Solution {
    public int maxArea(int[] heights) {
        int volume = 0;
        int l = 0, r = heights.length-1;

        while(l<r){
            int tempVolume = (r-l)* min(heights[l],heights[r]);
            
            volume = max(volume,tempVolume);
            if(heights[l]<=heights[r])
                l++;
            else
                r--;
        }
        return volume;
    }
    public int max(int a,int b){
        return a>b? a : b;
    }
    public int min(int a ,int b){
        return a<b? a: b;
    }
}
