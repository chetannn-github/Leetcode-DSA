class MapSum {
    Trie prefixTree;
    public MapSum() {
        prefixTree = new Trie();
    }
    
    public void insert(String key, int val) {
        prefixTree.insert(key,val);
    }

    public int sum(String prefix) {
        return prefixTree.sum(prefix);
    }
}

class Trie {
    TrieNode root;
    HashMap<String,Integer> added;
    Trie() {
        root = new TrieNode(0);
        added = new HashMap<>();
    }

    void insert(String key, int val) {
        TrieNode curr = root;
        int effectiveVal = val - added.getOrDefault(key,0);

        for(char ch : key.toCharArray()) {
            if(curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new TrieNode(effectiveVal);
            }else {
                curr.children[ch-'a'].val += effectiveVal;
            }
            
            curr = curr.children[ch-'a'];
        }
        added.put(key, val);
        
    }


    int sum(String prefix) {
        int result = 0;
        TrieNode curr = root;

        for(char ch : prefix.toCharArray()) {
            if(curr.children[ch-'a'] == null) return 0;
            curr = curr.children[ch-'a'];
        }

        return curr.val;
    }

    
}


class TrieNode {
    int val;
    TrieNode[] children;
    
    TrieNode(int val) {
        this.val = val;
        children = new TrieNode[26];
    }

}