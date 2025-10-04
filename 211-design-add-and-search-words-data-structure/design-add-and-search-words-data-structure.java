class WordDictionary {
    Trie prefixTree;
    public WordDictionary() {
        prefixTree = new Trie();
    }
    public void addWord(String word) {
        prefixTree.insert(word);
    }
    
    public boolean search(String word) {
        return prefixTree.search(word, 0, prefixTree.root);
    }
}



class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word, int idx, TrieNode curr) {
        if(idx >= word.length()) return curr.isEndOfWord;

        char currChar = word.charAt(idx);

        if(currChar == '.') {
            for(int i=0; i<26; i++) {
                if(curr.children[i] != null) {
                    if(search(word, idx + 1, curr.children[i])) {
                        return true;
                    }
                }
            }
        }else {
            if(curr.children[currChar - 'a'] == null) return false;
            else return search(word,idx+1,curr.children[currChar - 'a']);
        }

        return false;
    }
}


class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}