// class Solution {
//     public List<List<String>> suggestedProducts(String[] products, String searchWord) {
//         Trie prefixTree = new Trie(); 
//         for(String product : products) {
//             prefixTree.insert(product);
//         }
//         List<List<String>> results = new ArrayList<>();

//         for(int i=1; i<=searchWord.length(); i++) {
//             String prefix = searchWord.substring(0,i);
//             results.add(prefixTree.findThreeSuggestions(prefix));
//         }
//         return results;
//     }
// }

// class Trie {
//     TrieNode root;
//     Trie() {
//         root = new TrieNode();
//     }
//     void insert(String word) {
//         TrieNode curr = root;
        
//         for(char ch : word.toCharArray()) {
//             if(curr.children.get(ch) == null) {
//                 curr.children.put(ch, new TrieNode());
//             }
//             curr = curr.children.get(ch);
            
//             curr.words.add(word);
//         }
//         curr.isEndOfWord = true;
//     }

//     List<String> findThreeSuggestions(String prefix) {
//         TrieNode curr = root;
        
//         for(char ch : prefix.toCharArray()) {
//             if(curr.children.get(ch) == null) return new ArrayList<>();
//             curr = curr.children.get(ch);
//             // System.out.println(curr.words.toString());
//         }
//         List<String> suggestions = curr.words;
//         Collections.sort(suggestions); 
//         return suggestions.subList(0,Math.min(3,suggestions.size()));
//     }
// }

// class TrieNode {
//     HashMap<Character,TrieNode> children;
//     boolean isEndOfWord;
//     List<String> words;

//     TrieNode() {
//         isEndOfWord = false;
//         words = new ArrayList<>();
//         children = new HashMap<>();
//     }
// }


// ek idea yhh bhii ho sktaa hh shuru me hii bataa do kitne suggest krogee 
// aur input ko sort krrr detee hhh 
// aur har node ko hum atmax utne hii words rkhegee

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie prefixTree = new Trie(3); 

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
    int maxSuggestions;
    
    Trie(int k) {
        maxSuggestions = k;
        root = new TrieNode();
    }
    void insert(String word) {
        TrieNode curr = root;
        
        for(char ch : word.toCharArray()) {
            if(curr.children.get(ch) == null) {
                curr.children.put(ch, new TrieNode());
            }
            curr = curr.children.get(ch);
            
            if(curr.words.size() < maxSuggestions) curr.words.add(word);
        }
    }

    List<String> findThreeSuggestions(String prefix) {
        TrieNode curr = root;
        
        for(char ch : prefix.toCharArray()) {
            if(curr.children.get(ch) == null) return new ArrayList<>();
            curr = curr.children.get(ch);
            // System.out.println(curr.words.toString());
        }
        return curr.words;
    }
}

class TrieNode {
    HashMap<Character,TrieNode> children;
    List<String> words;
    
    TrieNode() {
        words = new ArrayList<>();
        children = new HashMap<>();
    }
}