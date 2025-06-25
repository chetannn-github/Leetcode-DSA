class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie prefixTree = new Trie();

        for(String str : strs){
            prefixTree.insert(str);
        }
        int lengthOfCommonPrefix = prefixTree.getLongestCommanPrefix();
        return lengthOfCommonPrefix == 0 ? new String("") : strs[0].substring(0,lengthOfCommonPrefix);
    }
}

class Trie {
    TrieNode root;
    boolean emptyString = false;
    Trie() {
        root = new TrieNode();
    }
    void insert(String val) {
        if(val.equals("")){
            emptyString = true;
        }
        if(emptyString) return;
        
        TrieNode curr = root;
        for(char ch : val.toCharArray()){
            if(curr.children.get(ch) == null){
                curr.children.put(ch,new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        curr.isEndOfWord = true;
    }

    int getLongestCommanPrefix() {
        if(emptyString) return 0;

        TrieNode curr = root;
        int idx = 0;
        while(!curr.isEndOfWord && curr.children.size() == 1){
            for(char key : curr.children.keySet()){
                curr = curr.children.get(key);
            }
            idx++;
        }

        return idx;
    }


}

class TrieNode {
    HashMap<Character,TrieNode> children;
    boolean isEndOfWord;
    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}