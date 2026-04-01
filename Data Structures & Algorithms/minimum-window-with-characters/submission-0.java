class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> mapS = new HashMap<>();
        HashMap<Character,Integer> mapT = new HashMap<>();
       
        for(int i = 0; i< t.length(); i++){
            mapT.put(t.charAt(i),mapT.getOrDefault(t.charAt(i),0)+1);
        }
       
        int l = 0; 
        int have = 0;
        int need = mapT.size();
        String minWindow = "";
        int minLen = Integer.MAX_VALUE;
        for(int r = 0; r<s.length(); r++){
            char rightChar = s.charAt(r);
             mapS.put(rightChar,mapS.getOrDefault(rightChar,0)+1);
             if(mapT.containsKey(rightChar) && mapS.get(rightChar).equals(mapT.get(rightChar))) {
                have ++;
             }   
            while(have == need){
             if(r-l+1< minLen){
                minLen = r-l+1;
                minWindow = s.substring(l,r+1);
             }
             
            char leftChar = s.charAt(l);
            mapS.put(leftChar, mapS.get(leftChar)-1);
            if(mapT.containsKey(leftChar) && mapS.get(leftChar)<mapT.get(leftChar)){
                have --;
            }

            l++;
         }
        }
    
        

        return minWindow;
    }
    }

