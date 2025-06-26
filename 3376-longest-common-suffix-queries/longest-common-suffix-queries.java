class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie suffixTree = new Trie(wordsContainer);
        int n = wordsQuery.length;

        for(int i = 0; i < wordsContainer.length; i++) {
            String reversedWord = reverseString(wordsContainer[i]);
            suffixTree.insert(reversedWord, i);
        }

        int[] result = new int[n];
        int idx = 0;

        for(String word : wordsQuery) {
            String reversedWord = reverseString(word);
            result[idx++] = suffixTree.lengthOfLongestCommonPrefix(reversedWord);
        }
        return result;


    }


    private String reverseString(String st){
        return new StringBuilder(st).reverse().toString();
    }
}


class Trie {
    TrieNode root;
    String[] wordsContainer;
    
    Trie(String[] wordsContainer) {
        this.wordsContainer = wordsContainer;
        root = new TrieNode();
    }

    void insert(String st, int idx) {
        TrieNode curr = root;
        int n = st.length();

        boolean unAssigned = (curr.result == -1);
        boolean moreShorter = !unAssigned && wordsContainer[curr.result].length() > n;

        if(unAssigned || moreShorter) {
            curr.result = idx;
        }

        for(char ch : st.toCharArray()) {
            if(curr.children.get(ch) == null) {
                curr.children.put(ch, new TrieNode());
            }

            unAssigned = (curr.children.get(ch).result == -1);
            moreShorter = !unAssigned && wordsContainer[curr.children.get(ch).result].length() > n;

            if(unAssigned || moreShorter) {
                curr.children.get(ch).result = idx;
            }
            curr = curr.children.get(ch);
        }
        
    }

    int lengthOfLongestCommonPrefix(String word) {
        TrieNode curr = this.root;
        for(char ch : word.toCharArray()) {
            if(curr.children.get(ch) == null) {
                break;
            }
            curr = curr.children.get(ch);
        }    
        return curr.result;
    }
  
}

class TrieNode {
    HashMap<Character,TrieNode> children;
    int result;
    TrieNode() {
        result = -1;
        children = new HashMap<>();
    }
}


