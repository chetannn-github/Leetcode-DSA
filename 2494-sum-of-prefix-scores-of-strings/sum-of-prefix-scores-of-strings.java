class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie prefixTree = new Trie();

        for (String word : words) {
            prefixTree.insert(word);
        }

        int[] result = new int[words.length];
        int idx = 0;
        for (String word : words) {
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
            int i = ch - 'a';
            if (curr.children[i] == null) {
                curr.children[i] = new TrieNode();
            }
            curr = curr.children[i];
            curr.val++;
        }
    }

    int calculatePrefixScore(String word) {
        TrieNode curr = this.root;
        int prefixScore = 0;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            curr = curr.children[i];
            prefixScore += curr.val;
        }
        return prefixScore;
    }
}


class TrieNode {
    TrieNode[] children;
    int val;

    TrieNode() {
        this.val = 0;
        this.children = new TrieNode[26];
    }
}
