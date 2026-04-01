class Solution {
    public int lengthOfLongestSubstring(String s) {
      HashSet<Character> set = new HashSet<>();
      int l =0;
      int res =0;
      for(int r = 0; r<s.length(); r++){
        while(set.contains(s.charAt(r))){
            set.remove(s.charAt(l));
            l++;
        }
        set.add(s.charAt(r));
        res = max(res,r-l+1);
        
      }
      return res;
    }
    public int max(int a , int b){
        return a>b? a:b;
    }
}
