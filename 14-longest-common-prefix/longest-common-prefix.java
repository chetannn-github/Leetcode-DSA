class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie prefixTree = new Trie();

        for(String str : strs){
            if (str.length() == 0) return new String("");
            prefixTree.insert(str);
        }
        int LCP = prefixTree.getLongestCommanPrefix();
        String LCPString = LCP == 0 ? 
            new String("") :
            strs[0].substring(0,LCP)
        ;
        return LCPString;
    }
}

class Trie {
    TrieNode root;
    
    Trie() {
        root = new TrieNode();
    }
    void insert(String val) {
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