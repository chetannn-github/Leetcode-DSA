// class Solution {
//     public int minimumLengthEncoding(String[] words) {
//         int count = 0;
//         HashMap<String,Integer> freq = new HashMap<>();
//         HashSet<Integer> discardedIndices = new HashSet<>();

//         for(int i = 0; i < words.length; i++) {
//             freq.put(words[i], freq.getOrDefault(words[i] ,0) +1);

//             Trie suffixTree = new Trie();
//             String reversedWord = reverseString(words[i]);
//             suffixTree.insert(reversedWord);

//             for(int j = 0; j< words.length; j++) {
//                 if(i==j || discardedIndices.contains(j)) continue;
                
//                 if(suffixTree.isPartOfSuffix(reverseString(words[j]))) {
//                     discardedIndices.add(j);
//                 }
//             }
            

//         }
//         // System.out.println(discardedIndices.toString());
//         for(int i=0; i<words.length; i++) {
//             if(!discardedIndices.contains(i)) {
//                 count += words[i].length() + 1;
//             }
//         }

//         for(String key : freq.keySet()) {
//             if(freq.get(key) > 1) {
//                 count += 1 + key.length();
//             }
//         }
//         return count;
//     }

//     public String reverseString(String st){
//         return new StringBuilder(st).reverse().toString();
//     }
// }

// class Trie {
//     TrieNode root;
//     Trie() {
//         root = new TrieNode();
//     }

//     void insert(String st) {
//         TrieNode curr = root;
//         for(char ch : st.toCharArray()) {
//             if(curr.children.get(ch) == null) {
//                 curr.children.put(ch, new TrieNode());
//             }
//             curr = curr.children.get(ch);
//         }
//         curr.isEndOfWord = true;
//     }

//     boolean isPartOfSuffix(String st) {
//         TrieNode curr = root;

//         for(char ch : st.toCharArray()) {
//             if(curr.children.get(ch) == null) return false;
//             curr = curr.children.get(ch);
//         }
//         return true;
//     }
// }

// class TrieNode {
//     HashMap<Character,TrieNode> children;
//     boolean isEndOfWord;
//     TrieNode() {
//         isEndOfWord = false;
//         children = new HashMap<>();
//     }
// }



// class Solution {
//     public int minimumLengthEncoding(String[] words) {
//         Set<String> wordSet = new HashSet<>(Arrays.asList(words));

//         for (String word : words) {
//             for (int i = 1; i < word.length(); i++) {
//                 wordSet.remove(word.substring(i));
//             }
//         }

//         int result = 0;
//         for (String word : wordSet) {
//             result += word.length() + 1;
//         }

//         return result;
//     }
// }


class Solution {
    public int minimumLengthEncoding(String[] words) {
        Trie suffixTrie = new Trie();
        HashMap<TrieNode, Integer> wordEndNodeIndexMap = new HashMap<>();

        
        for (int i = 0; i < words.length; i++) {
            String reversed = reverseString(words[i]);
            TrieNode curr = suffixTrie.root;

            for (char ch : reversed.toCharArray()) {
                if(curr.children.get(ch) == null){
                    curr.children.put(ch, new TrieNode());
                }
                curr = curr.children.get(ch);
            }
            wordEndNodeIndexMap.put(curr, i);
        }

        int totalLength = 0;
        for (TrieNode node : wordEndNodeIndexMap.keySet()) {
            if (node.children.isEmpty()) {
                int idx = wordEndNodeIndexMap.get(node);
                totalLength += words[idx].length() + 1;
            }
        }

        return totalLength;
    }

    public String reverseString(String st) {
        return new StringBuilder(st).reverse().toString();
    }
}

class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }
}

class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
        children = new HashMap<>();
    }
}
