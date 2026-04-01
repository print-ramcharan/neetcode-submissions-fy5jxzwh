class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        for (int[] row : points) { 
             // Iterate through each row (1D array)
            // int x= row[0] ? row[0]:0;
            // int y= row[1] ? row[1]:0;
            int x = row[0];
            int y = row[1];
            // int distance;
            // if(x == 0 || y == 0){
            //     distance = x?x:y;
            // }else{
                int distance = (x*x +y*y);
            // }
            minHeap.offer(new int[] {distance,x,y});
        }
        
        //want to return the top k elements. but there is only distance we dont know points form it so i want to add the index too in the pq ? will this work?
       int [][] pnts = new int[k][2];
        while(k > 0){
           int  closest[] = minHeap.poll();
           pnts[--k] = new int[]{closest[1],closest[2]};
            
        }
        return pnts;

    }
}
