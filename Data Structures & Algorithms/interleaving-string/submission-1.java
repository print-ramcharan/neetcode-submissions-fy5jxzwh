class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return dfs(s1, s2, s3, 0, 0);
    }

    private boolean dfs(String s1, String s2, String s3, int i, int j){

        int n = s1.length();
        int m = s2.length();

        if(i == n && j == m) return true;

        if(i < n && s1.charAt(i) == s3.charAt(i + j) && dfs(s1, s2, s3, i + 1, j)) return true;  

        if(j < m && s2.charAt(j) == s3.charAt(i + j) && dfs(s1, s2, s3, i, j + 1)) return true;

        return false;


    }
}
