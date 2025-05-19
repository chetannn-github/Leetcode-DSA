class TrieNode{
    boolean isEndOfWord;
    HashMap<Character,TrieNode> children;
    
    public TrieNode(){
        children = new HashMap<>();
        isEndOfWord = false;
    }
}



class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;

        for(char ch : word.toCharArray()){
            if(curr.children.get(ch) == null){
                curr.children.put(ch,new TrieNode());
            }
            curr = curr.children.get(ch);
        }

        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children.get(ch) == null){
                return false;
            }
            curr = curr.children.get(ch);
        }

        return curr.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            current = current.children.get(ch);
            if (current == null) return false;
        }
        return true;
    }
}
