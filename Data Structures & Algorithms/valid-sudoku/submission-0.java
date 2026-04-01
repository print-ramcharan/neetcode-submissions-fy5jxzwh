class Solution {
    public boolean isValidSudoku(char[][] board) {
     
       for (int row=0; row<9; row++){
         HashSet<Character> set = new HashSet<>();
         for(int i= 0 ; i<9; i++){
            if(board[row][i]== '.')
                continue;
            if(set.contains(board[row][i])) 
                return false;
            set.add(board[row][i]);
         }

       } 
        for (int col=0; col<9; col++){
         HashSet<Character> set = new HashSet<>();
         for(int i= 0 ; i<9; i++){
            if(board[i][col]== '.')
                continue;
            if(set.contains(board[i][col])) 
                return false;
            set.add(board[i][col]);
         }

       } 

       for(int sqr =0 ; sqr <9 ; sqr++){
        HashSet<Character> set = new HashSet<>();
       for (int i = 0; i < 9; i++) { 
          int j = i / 3; 
          int k = i % 3;
          int row = (sqr/3)*3+j;
          int col = (sqr%3)*3+k;

          if(board[row][col]=='.') continue;
          if(set.contains(board[row][col])) return false;

          set.add(board[row][col]);

       }
    }
    return true;
    }
}
