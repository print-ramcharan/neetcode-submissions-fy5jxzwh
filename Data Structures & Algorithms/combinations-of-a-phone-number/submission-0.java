class Solution {
    private List<String> res = new ArrayList<>();
    private String[] digitsToChar = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        backtrack(0, "", digits);
        return res;
    
    }
    private void backtrack(int index, String curStr, String digits){
        if(curStr.length() == digits.length()){
            res.add(curStr);
            return;
        }
        String chars = digitsToChar[digits.charAt(index) - '0'];
        for(char c : chars.toCharArray()){
            backtrack(index + 1, curStr + c, digits);
        }
    }
}
