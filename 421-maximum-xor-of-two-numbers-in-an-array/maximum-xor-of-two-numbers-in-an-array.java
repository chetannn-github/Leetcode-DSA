class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie prefixTree = new Trie();

        for(int num : nums) {
            prefixTree.insert(num);
        }

        int maxXOR = 0;
        for(int num : nums) {
            maxXOR = Math.max(maxXOR, prefixTree.findMaxXOR(num));
        }
        return maxXOR;
    }
}



class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }

    void insert(int num) {
        TrieNode curr = root;

        for(int i=31; i>=0; i--) {
            int bit = num & (1<<i);
            if(bit == 0) {
                if(curr.left == null) curr.left = new TrieNode();
                curr = curr.left;
            }else {
                if(curr.right == null) curr.right = new TrieNode();
                curr = curr.right;
            }
        }
    }

    int findMaxXOR(int num) {
        TrieNode curr = root;
        int maxXORPossible = 0;

        for(int i=31; i>=0; i--) {
            int bit = num & (1<<i);

            if(bit == 0) {
                if(curr.right != null) {
                    curr = curr.right;
                    maxXORPossible = (maxXORPossible | (1 << i));
                } else {
                    curr = curr.left;
                }
            } else {
                if(curr.left != null) {
                    curr = curr.left;
                    maxXORPossible = (maxXORPossible | (1 << i));
                } else {
                    curr = curr.right;
                }
            }
        }

        return maxXORPossible;
    }
}


class TrieNode {
    TrieNode left, right;
}