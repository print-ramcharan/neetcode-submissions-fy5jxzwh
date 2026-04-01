class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<HashMap<Character,Integer>,List<String>> map = new HashMap<>();
       

       for(String str : strs){
        HashMap<Character,Integer> anagram1 = new HashMap<>();
       
         for(int j =0; j<str.length(); j++){
            anagram1.put(str.charAt(j),anagram1.getOrDefault(str.charAt(j),0)+1);
         }
         if(map.containsKey(anagram1)){
            map.get(anagram1).add(str);
         }else{
            List<String> tempList = new ArrayList<>();
            tempList.add(str);
            map.put(anagram1,tempList);
         }
       } 
        List<List<String>> result = new ArrayList<>();
        result.addAll(map.values());
        return result;
    }
}
