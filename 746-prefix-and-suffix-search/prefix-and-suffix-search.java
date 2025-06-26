// time limit exceeds

// class WordFilter {
//     Trie prefixTree , suffixTree;
//     String[] words;
//     public WordFilter(String[] words) {
//         prefixTree = new Trie();
//         suffixTree = new Trie();
//         this.words = words;

//         HashSet<String> addedWords = new HashSet();

//         for(int i = words.length -1 ; i>=0; i--) {
//             if(addedWords.contains(words[i])) continue;

//             prefixTree.insert(words[i], i);
//             suffixTree.insert(reverseString(words[i]), i);
//         }
//     }
    
//     public int f(String pref, String suff) {
//         HashSet<Integer>  wordsWithSamePrefix= prefixTree.searchWordsWithPrefix(pref);
//         HashSet<Integer> wordsWithSameSuffix = suffixTree.searchWordsWithPrefix(reverseString(suff));

//         int maxIndex = -1;
//         for(int idx : wordsWithSameSuffix) {
//             if(wordsWithSamePrefix.contains(idx)) {
//                 maxIndex = Math.max(maxIndex,idx);
//             }
//         }
//         // System.out.println(wordsWithSameSuffix.toString());

//         return maxIndex;
//     }

//     private String reverseString(String st){
//         return new StringBuilder(st).reverse().toString();
//     }
// }

// class Trie {
//     TrieNode root;
//     Trie () {
//         root = new TrieNode();
//     }
    
//     void insert (String word, int idx) {
//         TrieNode curr = root;
//         for(char ch : word.toCharArray()) {
//             if(curr.children.get(ch) == null) {
//                 curr.children.put(ch,new TrieNode());
//             }
//             curr = curr.children.get(ch);
//             curr.words.add(idx);
//         }
        
//     }

//     HashSet<Integer> searchWordsWithPrefix (String prefix) {
//         TrieNode curr = this.root;

//         for(char ch : prefix.toCharArray()) {
//             if(curr.children.get(ch) == null) {
//                 return new HashSet<>();
//             } 
//             curr = curr.children.get(ch);
//         }

//         return curr.words;
//     }


 
// }

// class TrieNode {
//     HashMap<Character,TrieNode> children;
//     HashSet<Integer> words;

//     TrieNode () {
//         children = new HashMap<>();
//         this.words = new HashSet<>();
//     }
// }



class WordFilter {
    TrieNode root = new TrieNode();

    public WordFilter(String[] words) {
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            int len = word.length();
            
            for (int i = 0; i <= len; i++) {
                String key = word.substring(len - i) + "#" + word;
                insert(key, index);
            }
        }
    }

    private void insert(String key, int index) {
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
            node.weight = index; 
        }
    }

    public int f(String pref, String suff) {
        String key = suff + "#" + pref;
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return -1;
            }
            node = node.children.get(c);
        }
        return node.weight;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    int weight = -1;
}



