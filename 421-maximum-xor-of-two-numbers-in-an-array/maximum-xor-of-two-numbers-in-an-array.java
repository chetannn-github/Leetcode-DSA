class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie prefixTree = new Trie();
        for(int num : nums) {
            prefixTree.insert(num);
        }
        int maxXOR = 0;
        for(int num : nums){
            maxXOR = Math.max(maxXOR,prefixTree.findMaxXOR(num));
        }
        return maxXOR;
    }
}

class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }

    void insert (int num) {
        TrieNode curr = root;
        for(int i=31 ; i>=0; i--){
            int bit = (num>>i) & 1;

            if(bit == 0 ){
                if(curr.zero == null ) curr.zero = new TrieNode();
                curr = curr.zero;
            }else{
                if(curr.one == null ) curr.one = new TrieNode();
                curr = curr.one;
            }
            
        } 
    }

    int findMaxXOR (int num) {
        TrieNode curr = root;
        int maxVal = 0;

        for(int i=31; i>=0; i--){
            int bit = (num>>i) & 1;
            int optimumVal = 1 - bit;

            if((optimumVal == 0 && curr.zero == null) || (optimumVal == 1 && curr.one == null) ){
                if(optimumVal == 0){
                    curr = curr.one;
                }else{
                    curr = curr.zero;
                }
            }else{
                if(optimumVal == 0){
                    curr = curr.zero;
                }else{
                    curr = curr.one;
                }
                maxVal |= (1<<i);
            }
            
        }

        return maxVal;
    }
}

class TrieNode {
    TrieNode zero;
    TrieNode one;
    TrieNode () {
        zero = null;
        one = null;
    }
}