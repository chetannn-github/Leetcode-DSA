class WordDictionary {
    Trie prefixTree;
    public WordDictionary() {
        prefixTree = new Trie();
    }
    
    public void addWord(String word) {
        TrieNode curr = prefixTree.root;

        for(char ch : word.toCharArray()){
            if(curr.children.get(ch) == null){
                curr.children.put(ch,new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return searchInNode(word, 0, prefixTree.root);
    }

    private boolean searchInNode(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char ch = word.charAt(index);
        
        if (ch == '.') {
            for (char key : node.children.keySet()) {
                if (searchInNode(word, index + 1, node.children.get(key))) {
                    return true;
                }
            }
            return false;
        }else{
            TrieNode child = node.children.get(ch);
            if (child == null) return false;
            return searchInNode(word, index + 1, child);
        }
    }

}

class TrieNode {
    HashMap<Character,TrieNode> children;
    boolean isEndOfWord;
    TrieNode(){
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class Trie {
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }
}