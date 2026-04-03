class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            res.putIfAbsent(sortedString, new ArrayList<>());
            res.get(sortedString).add(s);
        } 
        return new ArrayList<>(res.values());   
    }
}
