class Solution {
    public void setZeroes(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        
        boolean firstRowZero = false;
        boolean firstColZero = false;
        
        for (int j = 0; j < COLS; j++) {
            if (matrix[0][j] == 0) firstRowZero = true;
        }
        for (int i = 0; i < ROWS; i++) {
            if (matrix[i][0] == 0) firstColZero = true;
        }
        
        for (int i = 1; i < ROWS; i++) {
            for (int j = 1; j < COLS; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < ROWS; i++) {
            for (int j = 1; j < COLS; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (firstRowZero) {
            for (int j = 0; j < COLS; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstColZero) {
            for (int i = 0; i < ROWS; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}