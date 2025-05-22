class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        Trie prefixTree = new Trie();

        for (String word : dictionary) {
            prefixTree.insert(word);
        }
        StringBuilder ans = new StringBuilder();


        for (String word : words) {
            String replacement = prefixTree.findReplacement(word);
            if(replacement == null){
                ans.append(word + " ");
            }else{
                ans.append(replacement + " ");
            }
        }
        return ans.toString().trim();
    }
}

class Trie {
    TrieNode root;
    Trie () {
        root = new TrieNode();
    }

    void insert (String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children.get(ch) == null) {
                curr.children.put(ch, new TrieNode());
            } 
            curr = curr.children.get(ch);
        }
        curr.isEndOfWord = true;
        curr.word = word;
    }

    String findReplacement (String word) {
        TrieNode curr = root;

        for (char ch : word.toCharArray()) {
            if(curr.isEndOfWord){
                return curr.word;
            }else if(curr.children.get(ch) == null ){
                return null;
            }
            curr = curr.children.get(ch);
        }

        return null;
    }
}

class TrieNode {
    HashMap<Character,TrieNode> children;
    boolean isEndOfWord;
    String word;

    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}