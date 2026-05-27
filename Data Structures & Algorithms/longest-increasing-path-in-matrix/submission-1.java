class Solution {
    private int[][] memo;  
    private int[][] dir = new int[][] {{0,1}, {1, 0}, {-1, 0}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        memo = new int[r][c];
        int longest = 0;

        for(int i = 0; i < r; i ++){
            for(int j = 0; j < c; j ++){
                longest = Math.max(longest, dfs(matrix, i, j));
            }
        }
        return longest;
    }

    private int dfs(int[][] matrix, int i, int j){
        
        int n = matrix.length;
        int m = matrix[0].length;

        if(memo[i][j] != 0) return memo[i][j];

        int maxPath = 1;

        for(int[] d : dir){
            int nr = d[0] + i;
            int nc = d[1] + j;

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && matrix[nr][nc] > matrix[i][j]){

                int neighbourLength = 1 +dfs(matrix, nr, nc);
               
                maxPath = Math.max(neighbourLength, maxPath);
            }
        }

        return memo[i][j] = maxPath;
        
    }
}
