class Solution {
    Boolean[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(s1, s2, s3, 0, 0);
    }

    private boolean dfs(String s1, String s2, String s3, int i, int j) {
        int n = s1.length();
        int m = s2.length();

        if (i == n && j == m) return true;
        if (dp[i][j] != null) return dp[i][j];

        if (i < n && s1.charAt(i) == s3.charAt(i + j)) {
            if (dfs(s1, s2, s3, i + 1, j)) {
                return dp[i][j] = true;
            }
        }

        if (j < m && s2.charAt(j) == s3.charAt(i + j)) {
            if (dfs(s1, s2, s3, i, j + 1)) {
                return dp[i][j] = true;
            }
        }

        return dp[i][j] = false;
    }
}