class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode(-1);
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new TrieNode(ch-'a');
            }
            curr = curr.children[ch-'a'];
        }

        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;

        for(char ch : word.toCharArray()) {
            if(curr.children[ch-'a'] == null) {
                return false;
            }
            curr = curr.children[ch-'a'];
        }

        return curr.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch : prefix.toCharArray()) {
            if(curr.children[ch-'a'] == null) {
                return false;
            }
            curr = curr.children[ch-'a'];
        }

        return true;
    }
}




class TrieNode {
    TrieNode[] children;
    int  val;
    boolean isEndOfWord;
    TrieNode(int val) {
        this.isEndOfWord = false;
        this.val = val;
        this.children = new TrieNode[26];
    }
}