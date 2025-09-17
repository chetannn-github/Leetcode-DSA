class WordDictionary {
    Trie prefixTree;
    public WordDictionary() {
        prefixTree = new Trie();
    }
    
    public void addWord(String word) {
        prefixTree.insertWord(word);
    }
    
    public boolean search(String word) {
        return prefixTree.search(word,0,prefixTree.root);
    }
}


class Trie {
    TrieNode root;
    Trie () {
        root = new TrieNode();
    }
    void insertWord(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEndOfWord = true;
    }

    // boolean search(String word) {
    //     TrieNode curr = root;
    //     for(char ch : word.toCharArray()) {
    //         if(ch != '.') {
    //             if(curr.children[ch-'a'] == null) return false;
    //         }else {
    //             return false;
    //         }
    //         curr = curr.children[ch-'a'];
    //     }
    //     return curr.isEndOfWord;
    // }


    boolean search(String word, int idx, TrieNode curr) {

        if(idx == word.length()) return curr.isEndOfWord;
        boolean result = false;
        char ch = word.charAt(idx);

        if(ch != '.') {
            if(curr.children[ch-'a'] == null) return false;
            else {
                result = search(word,idx+1, curr.children[ch-'a']);
            }
        }else {
            for(int i=0; i<26; i++) {
                if(curr.children[i] != null) {
                    result = result || search(word, idx+1, curr.children[i]);
                }

                if(result) return true;
            }

        }
        return result;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    TrieNode () {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}