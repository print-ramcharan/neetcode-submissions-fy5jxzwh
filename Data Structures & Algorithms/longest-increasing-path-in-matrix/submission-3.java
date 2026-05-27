class Solution {
    private int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] outDegree = new int[r][c];
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int[] d : dir) {
                    int nr = i + d[0];
                    int nc = j + d[1];
                    if (nr >= 0 && nr < r && nc >= 0 && nc < c && matrix[nr][nc] > matrix[i][j]) {
                        outDegree[i][j]++;
                    }
                }
            }
        }
        
        int[] q = new int[r * c];
        int head = 0;
        int tail = 0;
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (outDegree[i][j] == 0) {
                    q[tail++] = i * c + j; 
                }
            }
        }
        
        int height = 0;
        while (head < tail) {
            int size = tail - head;
            height++;
            
            for (int i = 0; i < size; i++) {
                int curr = q[head++];
                int n = curr / c; 
                int m = curr % c; 
                
                for (int[] d : dir) {
                    int nr = n + d[0];
                    int nc = m + d[1];
                    if (nr >= 0 && nr < r && nc >= 0 && nc < c && matrix[nr][nc] < matrix[n][m]) {
                        outDegree[nr][nc]--;
                        if (outDegree[nr][nc] == 0) {
                            q[tail++] = nr * c + nc;
                        }
                    }
                }
            }
        }
        
        return height;
    }
}