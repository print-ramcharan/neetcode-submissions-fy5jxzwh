class Solution {
    public String foreignDictionary(String[] words) {
      
      Map<Character, Set<Character>> graph = new HashMap<>();
      Map<Character, Integer> inDegree = new HashMap<>();

      for(String word : words){
        for(char c : word.toCharArray()){
            inDegree.putIfAbsent(c, 0);
            graph.putIfAbsent(c, new HashSet<>());
        }
      }

      for(int i = 0; i < words.length - 1; i ++){
        String w1 = words[i], w2 = words[i + 1];
        int minLen = Math.min(w1.length(), w2.length());
        boolean foundDifference = false;
        for(int j = 0; j < minLen; j ++){
            char c1 = w1.charAt(j), c2 = w2.charAt(j);
            if(c1 != c2){
                if(!graph.get(c1).contains(c2)){
                    graph.get(c1).add(c2);
                    inDegree.put(c2, inDegree.get(c2) + 1);
                }
                foundDifference = true;
                break;
            }
        }
        if(!foundDifference && w1.length() > w2.length()) return "";

      }

      //kahn's algorithm
      Queue<Character> queue = new LinkedList<>();
      for(char c : inDegree.keySet()){
        if(inDegree.get(c) == 0) queue.offer(c);
      }

      StringBuilder result = new StringBuilder();
      while(!queue.isEmpty()){
        char c = queue.poll();
        result.append(c);
        for(char nei : graph.get(c)){
            inDegree.put(nei, inDegree.get(nei) - 1);
            if(inDegree.get(nei) == 0) queue.offer(nei);
        }
      }
      return result.length() == inDegree.size() ? result.toString() : "";
    }
}
