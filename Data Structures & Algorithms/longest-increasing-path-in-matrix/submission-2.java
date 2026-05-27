class Solution {
    private int[][] memo;  
    private int[][] dir = new int[][] {{0,1}, {1, 0}, {-1, 0}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        int[][] outDegree = new int[r][c];

        for(int i = 0; i < r; i ++){
            for(int j = 0; j < c; j ++){
                
                for(int[] d : dir){
                    int nr = d[0] + i;
                    int nc = d[1] + j;

                    if(nr >= 0 && nr < r && nc >= 0 && nc < c && matrix[nr][nc] > matrix[i][j]){

                        outDegree[i][j] ++; 
                    }
                }

            }
        }

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < r; i ++){
            for(int j = 0; j < c; j ++){
                if(outDegree[i][j] == 0){
                    q.add(new int[]{i, j});
                }
            }
        }

        int height = 0;

        while(!q.isEmpty()){
            int size = q.size();
            height ++;

            for(int i = 0;i < size; i ++){
                int[] curr = q.poll();

                int n = curr[0];
                int m = curr[1];

                for(int[] d : dir){
                    int nr = d[0] + n;
                    int nc = d[1] + m;

                    if(nr >= 0 && nr < r && nc >= 0 && nc < c && matrix[nr][nc] < matrix[n][m]){
                        outDegree[nr][nc] --;
                        if(outDegree[nr][nc] == 0){
                            q.add(new int[]{nr, nc});
                        }

                    }
                }
        
        
            }
        }
        
        return height;
    }
}
