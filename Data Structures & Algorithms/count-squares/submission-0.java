class CountSquares {
    private int[][] pointCounts;

    private List<int[]> pointsList;

    public CountSquares() {
        pointCounts = new int[1001][1001];
        pointsList = new ArrayList<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        pointCounts[x][y] ++;
        pointsList.add(point);
    }
    
    public int count(int[] point) {
        int qx = point[0];
        int qy = point[1];
        int totalSquares = 0;

        for(int[] p : pointsList){
            int dx = p[0];
            int dy = p[1];

            if(qx == dx || qy == dy) continue;


            if(Math.abs(qx - dx) == Math.abs(qy - dy)){
                int c1Count = pointCounts[dx][qy];
                int c2Count = pointCounts[qx][dy];

                totalSquares += c1Count * c2Count;
            }
        }

        return totalSquares;
    }
}
