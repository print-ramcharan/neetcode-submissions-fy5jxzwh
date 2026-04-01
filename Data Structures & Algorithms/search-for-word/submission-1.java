class Solution {

    int ROWS, COLS;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        for(int r = 0; r < ROWS; r ++){
            for(int c = 0; c < COLS; c ++){
                if(dfs(board, r, c, word, 0)){
                    return true;
                }
            }
        }
        return false;
        // dfs(board, ROWS, COLS, word, 0);
    }
    private boolean dfs(char[][] board, int r, int c, String word, int index){
        if(index == word.length()) return true;
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] != word.charAt(index) || board[r][c] == '#'){
            return false;
        }
        board[r][c] = '#';
        boolean res = dfs(board, r +1, c, word, index + 1) 
                        ||
                      dfs(board, r - 1, c, word, index + 1)
                        ||
                      dfs(board, r, c + 1, word, index + 1)
                        ||
                      dfs(board, r, c - 1, word, index + 1);
        board[r][c] = word.charAt(index);
        return res;
    }
}
