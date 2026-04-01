class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> charcountS = new HashMap<>();
        HashMap<Character,Integer> charcountT = new HashMap<>();
        for(int i =0; i<s.length();  i++){
            charcountS.put(s.charAt(i),charcountS.getOrDefault(s.charAt(i),0)+1);
            charcountT.put(t.charAt(i),charcountT.getOrDefault(t.charAt(i),0)+1);
        }
        return charcountS.equals(charcountT);
    }
}
