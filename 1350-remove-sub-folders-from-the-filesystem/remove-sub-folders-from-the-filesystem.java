class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Trie prefixTree = new Trie();
        for(String word : folder) {
            prefixTree.insert(word);
        }
        return prefixTree.removeSub();
    }
}

class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }
    void insert (String word) {
        TrieNode curr = root;
        for(String ch : word.split("/")) {
            if(curr.children.get(ch) == null) {
                curr.children.put(ch, new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        curr.isEndOfWord = true;
        curr.word = word;
    }
    List<String> removeSub() {
        List<String> ans = new ArrayList<>();
        dfs(root,ans);
        return ans;
    }

    void dfs(TrieNode curr,List<String> ans ) {
        if(curr.isEndOfWord) {
            ans.add(curr.word);
            return;
        }

        for(String key : curr.children.keySet()) {
            dfs(curr.children.get(key), ans);
        }
    }
}

class TrieNode {
    HashMap<String,TrieNode> children;
    boolean isEndOfWord;
    String word;
    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}