class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String, List<Integer>> map = new HashMap<>();
        int i = 0;
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String temp = String.valueOf(chars);
            map.computeIfAbsent(temp, k -> new ArrayList<>()).add(i ++);
            
        }

        for(List<Integer> indices : map.values()){
            List<String> list = new ArrayList<>();
            for(int index : indices){
                list.add(strs[index]);
            }
            res.add(list);
        }
        return res;
    }
}
