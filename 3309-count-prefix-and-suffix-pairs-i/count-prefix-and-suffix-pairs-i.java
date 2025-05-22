class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        
        int count = 0;

        for(int i=0; i < words.length; i++) {
            Trie prefixTree = new Trie();
            Trie suffixTree = new Trie();

            prefixTree.insert(words[i]);
            suffixTree.insert(reverse(words[i]));

            for(int j = 0; j < i; j++) {
                if(prefixTree.startsWith(words[j]) && suffixTree.startsWith(reverse(words[j]))){
                    count++;
                }
            } 
            
        } 
        return count;
    }

    String reverse(String word){
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }
}



class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children.get(ch) == null){
                curr.children.put(ch, new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        curr.isEndOfWord = true;
    }

    boolean startsWith(String word){
        TrieNode curr = root;

        for(char ch : word.toCharArray()){
            if(curr.children.get(ch) == null) return false;
            curr = curr.children.get(ch);
        }

        return true;
    }
}

class TrieNode {
    HashMap<Character,TrieNode> children;
    boolean isEndOfWord;
    TrieNode() {
        isEndOfWord = false;
        children = new HashMap<>();
    }
}