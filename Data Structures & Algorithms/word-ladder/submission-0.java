class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> patternMap = new HashMap<>();

        for(String word : wordList){
            for(int i = 0; i < word.length(); i ++){
                String pattern = word.substring(0,i) + "*" + word.substring(i + 1);
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while(!queue.isEmpty()){
            Pair<String, Integer> current = queue.poll();
            String word = current.getKey();
            int steps = current.getValue();

            for(int i = 0; i < word.length(); i ++){
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                for(String neighbour : patternMap.getOrDefault(pattern, new ArrayList<>())){
                    if(neighbour.equals(endWord)){
                        return steps + 1;
                    }
                    if(!visited.contains(neighbour)){
                        visited.add(neighbour);
                        queue.add(new Pair<>(neighbour, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}
