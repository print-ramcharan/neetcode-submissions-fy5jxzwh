class Solution {
    public int minDistance(String word1, String word2) {
        return dfs(word1, word2, 0, 0);
    }

    private int dfs(String word1, String word2, int i, int j){
        int n = word1.length();
        int m = word2.length();

        
        if(i == n) return m - j;

        if(j == m) return n - i;

        if(word1.charAt(i) == word2.charAt(j)){
            
            return dfs(word1, word2, i + 1, j + 1);

        }
          
            int insert = dfs(word1, word2, i, j + 1);
            int delete = dfs(word1, word2, i + 1, j);
            int replace = dfs(word1, word2, i + 1, j + 1);

        return 1 + Math.min(insert, Math.min(delete, replace));

    }
}
