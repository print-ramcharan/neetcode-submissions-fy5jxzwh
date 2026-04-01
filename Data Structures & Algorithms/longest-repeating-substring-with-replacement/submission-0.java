class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> set = new HashMap<>();
        int res = 0;
        int l = 0;
        int maxfreq = 0;

        for(int i =0; i<s.length();i++){
          
             set.put(s.charAt(i),set.getOrDefault(s.charAt(i),0)+1);
             maxfreq = max(maxfreq, set.get(s.charAt(i)));
             while((i-l+1)-maxfreq >k){
               set.put(s.charAt(l),set.get(s.charAt(l))-1);
               l++;
             }
             res = max(res, i-l+1);
        }
        return res;
    }
    public int max(int a, int b){
        return a>b? a:b;

    }
}
