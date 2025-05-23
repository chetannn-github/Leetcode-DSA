class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie prefixTree = new Trie(); 
        for(String product : products) {
            prefixTree.insert(product);
        }
        List<List<String>> results = new ArrayList<>();

        for(int i=1; i<=searchWord.length(); i++) {
            String prefix = searchWord.substring(0,i);
            results.add(prefixTree.findThreeSuggestions(prefix));
        }
        return results;
    }
}

class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }
    void insert(String word) {
        TrieNode curr = root;
        
        for(char ch : word.toCharArray()) {
            if(curr.children.get(ch) == null) {
                curr.children.put(ch, new TrieNode());
            }
            curr = curr.children.get(ch);
            curr.words.add(word);
        }
        curr.isEndOfWord = true;
    }

    List<String> findThreeSuggestions(String prefix) {
        TrieNode curr = root;
        
        for(char ch : prefix.toCharArray()) {
            if(curr.children.get(ch) == null) return new ArrayList<>();
            curr = curr.children.get(ch);
            // System.out.println(curr.words.toString());
        }
        List<String> suggestions = curr.words;
         Collections.sort(suggestions); 
        return suggestions.subList(0,Math.min(3,suggestions.size()));
    }
}

class TrieNode {
    HashMap<Character,TrieNode> children;
    boolean isEndOfWord;
    List<String> words;

    TrieNode() {
        isEndOfWord = false;
        words = new ArrayList<>();
        children = new HashMap<>();
    }
}