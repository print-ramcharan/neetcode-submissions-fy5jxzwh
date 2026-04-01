class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
    
}
class WordDictionary {
    private TrieNode root ;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
    return searchInNode(word, 0, root);
}

private boolean searchInNode(String word, int index, TrieNode node) {
    if (index == word.length()) {
        return node.endOfWord;
    }
    char c = word.charAt(index);
    if (c == '.') {
        for (TrieNode child : node.children.values()) {
            if (searchInNode(word, index + 1, child)) {
                return true;
            }
        }
        return false;
    } else {
        if (!node.children.containsKey(c)) return false;
        return searchInNode(word, index + 1, node.children.get(c));
    }
}

}
