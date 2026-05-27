class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

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

        if(i == n || j == m || i < 0 || j < 0  && matrix[i][j] == -1) return 0;


        int[][] dir = new int[][] {{0,1}, {1, 0}, {-1, 0}, {0, -1}};

        int maxPath = 1;

        for(int[] d : dir){
            int nr = d[0] + i;
            int nc = d[1] + j;

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && matrix[nr][nc] > matrix[i][j]){

                int neighbourLength = 1 +dfs(matrix, nr, nc);
               
                maxPath = Math.max(neighbourLength, maxPath);
            }
        }

        return maxPath;
        
    }
}
