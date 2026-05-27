class Solution {
    private Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(s, p, 0, 0);
    }

    private boolean dfs(String s, String p, int i, int j) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (i == s.length() && j == p.length()) {
            return memo[i][j] = true;
        }
        if (j == p.length()) {
            return memo[i][j] = false;
        }

        boolean match = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            boolean res = dfs(s, p, i, j + 2) || (match && dfs(s, p, i + 1, j));
            return memo[i][j] = res;
        }

        if (match) {
            return memo[i][j] = dfs(s, p, i + 1, j + 1);
        }

        return memo[i][j] = false;
    }
}