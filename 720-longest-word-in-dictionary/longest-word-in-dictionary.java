class Solution {
    public String longestWord(String[] words) {
        Trie prefixTree = new Trie();

        for(String word : words) {
            prefixTree.insert(word);
        }

        return prefixTree.searchLongestWord();
    }
}

class Trie {
    TrieNode root;
    Trie () {
        root = new TrieNode();
    }
    
    void insert (String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.children.get(ch) == null) {
                curr.children.put(ch,new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        curr.isEndOfWord = true;
        curr.word = word;
    }

    String searchLongestWord() {
        dfs(root);
        return maxLengthWord;
    }
    String maxLengthWord = "";

    void dfs(TrieNode curr) {
        if(curr.word != null){
            if(maxLengthWord.length() < curr.word.length()){
                maxLengthWord = curr.word;
            }else if(maxLengthWord.length() == curr.word.length()){
                maxLengthWord = getLexicographicallySmaller(curr.word,maxLengthWord);
            }
            
        }
        
        for(char key : curr.children.keySet()) {
            if(curr.children.get(key).isEndOfWord) {
                dfs(curr.children.get(key));
            }
        }

    }

    String getLexicographicallySmaller(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if (ch1 < ch2) {
                return str1;
            } else if (ch1 > ch2) {
                return str2;
            }
        }
        return str1;
    }

    
}

class TrieNode {
    HashMap<Character,TrieNode> children;
    boolean isEndOfWord;
    String word;
    TrieNode () {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}