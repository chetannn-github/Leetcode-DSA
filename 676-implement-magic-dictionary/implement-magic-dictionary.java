class MagicDictionary {
    Trie prefixTree;
    public MagicDictionary() {
        prefixTree = new Trie();
    }
    
    public void buildDict(String[] dictionary) {
        for(String st : dictionary){
            prefixTree.insert(st);
        }
    }
    
    public boolean search(String searchWord) {
        return prefixTree.search(searchWord);
    }
}

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
        return searchInNode(word,0,root,true,word.length());
    }

    private boolean searchInNode(String word, int idx, TrieNode curr, boolean canModify,int n) {
        if (idx == n) {
            return !canModify && curr.isEndOfWord;
        }

        char ch = word.charAt(idx);
        if (curr.children.containsKey(ch)) {
            if (searchInNode(word, idx + 1, curr.children.get(ch), canModify,n)) {
                return true;
            }
        }

        if (canModify) {
            for (char key : curr.children.keySet()) {
                if (key != ch) {
                    if (searchInNode(word, idx + 1, curr.children.get(key), false,n)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    
    
}

