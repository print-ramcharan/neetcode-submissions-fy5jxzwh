class Solution {
    public int minCostConnectPoints(int[][] points) {
    int n = points.length;
    boolean[] inMST = new boolean[n];
    int[] minDist = new int[n];
    Arrays.fill(minDist, Integer.MAX_VALUE);
    minDist[0] = 0;
    int result = 0;

    for(int i = 0; i < n; i ++){
        int u = -1;
        for(int j = 0; j < n; j ++){
            if(!inMST[j] && (u == -1 || minDist[j] < minDist[u])){
                u = j;
            }
        }

        inMST[u] = true;
        result += minDist[u];

        for(int v = 0; v < n; v ++){
            if(!inMST[v]){
                int dist = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                if(dist < minDist[v]){
                    minDist[v] = dist;
                }
            }
        }
    }
     return result;
    }
}
    //     Map<Point, PriorityQueue<Integer>> graph = new HashMap<>();

    //     for(int point[] : points){
    //         int x = point[0], y = point[1];
    //         Point p = new Point(x, y);
    //         graph.put(p, new PriorityQueue<>());
    //     }
    //     calculateDistances(graph);


    // }
    // private void calculateDistances(Map<Point, PriorityQueue<Integer>> graph){
    //     for(Point src : graph.keySet()){
    //         PriorityQueue<Integer> distances = graph.get(src);
    //         distances.clear();

    //         for(Point dest : graph.keySet()){
    //             if(!src.equals(dest)){
    //                 int distance = Math.abs(src.getX() - dest.getX()) + Math.abs(src.getY() - dest.getY());
    //                 distances.add(distance);
    //             }
    //         }
    //     }
    // }
// }
// class Point{
//     int x, y;
    
//     public Point(int x, int y){
//         this.x = x;
//         this.y = y;
//     }
//     public int getX(){
//         return this.x;
//     }
//     public int getY(){
//         return this.y;
//     }
//     public boolean equals(Object o){
//         if(this == o) return true;
//         if(!(o instanceof Point)) return false;
//         Point p = (Point) o;
//         return this.x = p.x && this.y == p.y;
//     }
//     public int hashCode(){
//         return Object.hash(x,y);
//     }
    
// }
