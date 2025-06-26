class StreamChecker {
    Trie prefixTree = new Trie();

    HashSet<TrieNode> pending;
    public StreamChecker(String[] words) {
        for(String word : words) {
            this.prefixTree.insert(word);
        }

        pending = new HashSet<>();
    }
    
    public boolean query(char letter) {
        pending.add(this.prefixTree.root);

        boolean ans = false;
        HashSet<TrieNode> tobeAdded = new HashSet<>();

        for(TrieNode curr : pending) {
            if(curr.children.get(letter) != null) {
                if (!ans) ans = curr.children.get(letter).isEndOfWord;
                tobeAdded.add(curr.children.get(letter));
            }
            
        }
        pending = new HashSet<>();
        for(TrieNode curr : tobeAdded) {
            pending.add(curr);
        }

        return ans;
    }


}



class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String st) {
        TrieNode curr = this.root;
        for(char ch : st.toCharArray()) {
            if(curr.children.get(ch) == null) {
                curr.children.put(ch, new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        curr.isEndOfWord = true;
    }


}

class TrieNode {
    HashMap<Character,TrieNode> children;
    boolean isEndOfWord;
    TrieNode() {
        this.isEndOfWord = false;
        this.children = new HashMap<>();
    }
}

