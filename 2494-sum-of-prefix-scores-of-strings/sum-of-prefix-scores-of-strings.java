class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie prefixTree = new Trie();

        for(String word : words) {
            prefixTree.insert(word);
        }

        int[] result = new int[words.length];
        int idx = 0;
        for(String word : words) {
            result[idx++] = prefixTree.calculatePrefixScore(word);
        }

        return result;
    }
}


class Trie {
    TrieNode root;
    
    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode curr = this.root;
        for (char ch : word.toCharArray()) {
            if(curr.children.get(ch) == null) {
                curr.children.put(ch, new TrieNode());
            }
            curr.children.get(ch).val++;
            curr = curr.children.get(ch);
        }
    }

    

    int calculatePrefixScore(String word) {
        TrieNode curr = this.root;
        int prefixScore = 0;
        for (char ch : word.toCharArray()) {
            prefixScore += curr.children.get(ch).val;
            curr = curr.children.get(ch);
        }

        return prefixScore;
    }
}


class TrieNode {
    HashMap<Character,TrieNode> children;
    int val;

    TrieNode() {
        this.val = 0;
        this.children = new HashMap<>();
    }
}