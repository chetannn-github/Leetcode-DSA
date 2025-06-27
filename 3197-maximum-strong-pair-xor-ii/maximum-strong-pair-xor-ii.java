class Solution {
    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);
        Trie prefixTree = new Trie();
        int maxXOR = 0;
        int addedIdx = 0;
        int n = nums.length;

        for(int i= 0; i<n; i++){
            
            if(addedIdx == i) {
                prefixTree.insert(nums[i], i);
                addedIdx++;

            }
            
            while(addedIdx < n && nums[addedIdx] - nums[i] <= nums[i]){
                // System.out.println(i + " -> " + addedIdx);
                prefixTree.insert(nums[addedIdx], addedIdx++);
            }
            maxXOR = Math.max(maxXOR,prefixTree.findMaxXOR(nums[i], i)); 
        }
        return maxXOR;
    }
}



class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }

    void insert (int num, int idx) {
        TrieNode curr = root;
        for(int i=31 ; i>=0; i--){
            int bit = (num>>i) & 1;

            if(bit == 0 ){
                if(curr.zero == null ) curr.zero = new TrieNode();
                curr = curr.zero;
            }else{
                if(curr.one == null ) curr.one = new TrieNode();
                curr = curr.one;
            }curr.maxIdx = idx;
            
        } 
    }

    int findMaxXOR (int num, int idx) {
        TrieNode curr = root;
        int maxVal = 0;

        for(int i=31; i>=0; i--){
            int bit = (num>>i) & 1;
            int optimumVal = 1 - bit;

            if((optimumVal == 0 && (curr.zero == null || curr.zero.maxIdx < idx)) || (optimumVal == 1 && (curr.one == null || curr.one.maxIdx < idx)) ){
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
    int maxIdx ;
    TrieNode () {
        zero = null;
        one = null;
        maxIdx = 0;
    }
}