class Solution {
    public int countPairs(int[] nums, int low, int high) {
        Trie prefixTree = new Trie();
        for(int num : nums ) {
            prefixTree.insert(num);
        }
        long totalPairs = 0;
        for(int num : nums) {
            long pairsLessThanHighPlusOne = prefixTree.countPairsXORLessThanX((high + 1) , num);
            long pairsLessThanLow = prefixTree.countPairsXORLessThanX(low , num);
            totalPairs += pairsLessThanHighPlusOne - pairsLessThanLow;
        }

        return (int) totalPairs / 2;
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
            curr.freq++;
            
        } 
    }


    long countPairsXORLessThanX(int limit, int num) {
        TrieNode curr = root;

        long pairsCount = 0;

        for(int i=31; i>=0; i--){
            int bitInNum = (num >> i) & 1;
            int bitInLimit = (limit >> i) & 1;

            // 0 , 1

            if(bitInNum == 0) {
                if(bitInLimit == 0) {
                    if(curr.zero != null) curr = curr.zero;
                    else break;
                }else {
                    pairsCount += curr.zero != null ? curr.zero.freq : 0 ;
                    
                    if(curr.one != null) curr = curr.one;
                    else break;
                }
            }else {
                if(bitInLimit == 0) {
                    if(curr.one != null) curr = curr.one;
                    else break;
                }else {
                    pairsCount += curr.one != null ? curr.one.freq : 0 ;
                    
                    if(curr.zero != null) curr = curr.zero;
                    else break;
                }
            }
        }
        return (pairsCount - 1) ;
    }
}

class TrieNode {
    TrieNode zero;
    TrieNode one;
    int freq ;
    TrieNode () {
        zero = null;
        one = null;
        freq = 0;
    }
}