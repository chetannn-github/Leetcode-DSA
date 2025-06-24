class MapSum {
    Trie prefixTree;
    public MapSum() {
        prefixTree = new Trie();
    }
    
    public void insert(String key, int val) {
        int pheleWaliValue = 0;
        if(prefixTree.addedStrings.containsKey(key)){
            pheleWaliValue = prefixTree.addedStrings.get(key);
        }
        prefixTree.addedStrings.put(key,val);
        TrieNode curr = prefixTree.root;
        val -= pheleWaliValue;
        
        for(char ch : key.toCharArray()){
            if(curr.children.get(ch) == null){
                curr.children.put(ch,new TrieNode(0));
            }
            curr.children.get(ch).value += val;  
            curr = curr.children.get(ch);
        }
    }
    
    public int sum(String prefix) {
        TrieNode current = prefixTree.root;
        for (char ch : prefix.toCharArray()) {
            current = current.children.get(ch);
            if (current == null) return 0;
        }
        return current.value;

        
    }
}


class Trie{
    TrieNode root;
    HashMap<String,Integer> addedStrings;
    Trie() {
        root = new TrieNode(0);
        addedStrings = new HashMap<>();
    }
}

class TrieNode {
    int value;
    HashMap<Character,TrieNode> children;

    TrieNode(int val) {
        value = val;
        children = new HashMap<>();
    }
}
