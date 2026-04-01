class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        // if(s.length() == 1){
        //     result.add(new ArrayList<>(Arrays.asList(s)));
        //     return result;
        // }
        dfs(s, 0, new ArrayList<>(), result);
        return result;
    }
    private void dfs(String s, int index, List<String> helper, List<List<String>> result){

        if(index >= s.length()){
            result.add(new ArrayList<>(helper));
            return;
        }
        for(int tail = index; tail < s.length(); tail ++){
            String temp = s.substring(index, tail + 1);
            if(isPalindrome(temp)){
                helper.add(temp);
                dfs(s, tail + 1, helper, result);
                helper.remove(helper.size() - 1);
            }
        }
    
       
    }
    private boolean isPalindrome(String s){
            if(s.length() == 1) return true;
            int l = 0, r = s.length() - 1;
            while(l <= r){
                if(s.charAt(l) != s.charAt(r)) return false;
                l ++;
                r --;
            }
            return true;
    }
}
