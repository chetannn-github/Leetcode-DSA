// class WordDictionary {
//     Trie prefixTree;
//     public WordDictionary() {
//         prefixTree = new Trie();
//     }
    
//     public void addWord(String word) {
//         TrieNode curr = prefixTree.root;

//         for(char ch : word.toCharArray()){
//             if(curr.children.get(ch) == null){
//                 curr.children.put(ch,new TrieNode());
//             }
//             curr = curr.children.get(ch);
//         }
//         curr.isEndOfWord = true;
//     }
    
//     public boolean search(String word) {
//         return searchInNode(word, 0, prefixTree.root);
//     }

//     private boolean searchInNode(String word, int index, TrieNode node) {
//         if (index == word.length()) {
//             return node.isEndOfWord;
//         }

//         char ch = word.charAt(index);
        
//         if (ch == '.') {
//             for (char key : node.children.keySet()) {
//                 if (searchInNode(word, index + 1, node.children.get(key))) {
//                     return true;
//                 }
//             }
//             return false;
//         }else{
//             TrieNode child = node.children.get(ch);
//             if (child == null) return false;
//             return searchInNode(word, index + 1, child);
//         }
//     }

// }

// class TrieNode {
//     HashMap<Character,TrieNode> children;
//     boolean isEndOfWord;
//     TrieNode(){
//         children = new HashMap<>();
//         isEndOfWord = false;
//     }
// }

// class Trie {
//     TrieNode root;
//     Trie(){
//         root = new TrieNode();
//     }
// }


class WordDictionary {
    Trie prefixTree;
    public WordDictionary() {
        prefixTree = new Trie();
    }
    
    public void addWord(String word) {
        prefixTree.insert(word);
        return;
    }
    
    public boolean search(String word) {
        return prefixTree.search(word,prefixTree.root,0, word.length());
    }


}


class Trie{
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }

    public void insert (String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.children.get(ch) == null) {
                curr.children.put(ch, new TrieNode());
            }
            curr = curr.children.get(ch);
        }

        curr.isEndOfWord = true;
    }

    public boolean search (String word, TrieNode curr, int start, int end) {

        for(int i=start; i<end; i++) {
            char ch = word.charAt(i);

            if(ch == '.') {
                // sare children ko dekhna padegaa
                for(char key : curr.children.keySet()) {
                    if (search(word, curr.children.get(key), i+1, end)) return true;
                }
                return false;
            } else {
                if(curr.children.get(ch) == null) return false;
                curr = curr.children.get(ch);
            }
        }

        return curr.isEndOfWord;
    }


}


class TrieNode{
    HashMap<Character,TrieNode> children;
    boolean isEndOfWord;

    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}