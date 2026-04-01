class Solution {
    public boolean isPalindrome(String s) {
        String s2 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int length = s2.length();
      int i =0,j=length-1;
      while(i<j){
        if(s2.charAt(i)!=s2.charAt(j))
            return false;
        i++;
        j--;
      }  
     return true;
    }
}
