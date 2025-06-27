class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        List<List<Integer>> queriesModified = new ArrayList<>();
        Arrays.sort(nums);
        Trie prefixTree = new Trie();

        for(int i=0; i<queries.length; i++) {
            List<Integer> q = new ArrayList<>();
            q.add(queries[i][0]);q.add(queries[i][1]);q.add(i);
            queriesModified.add(q);
        }

        Collections.sort(queriesModified, (a,b) -> (a.get(1) - b.get(1)));
        int addedIdx = 0;
        int[] result = new int[queries.length];
        int n = nums.length;

        for(List<Integer> q : queriesModified){
            int num = q.get(0);
            int ansIdx = q.get(2);
            int maxVal = q.get(1);

            
            
            while(addedIdx < n && nums[addedIdx] <= maxVal){
                // System.out.println(i + " -> " + addedIdx);
                prefixTree.insert(nums[addedIdx++]);
            }
            result[ansIdx] = prefixTree.findMaxXOR(num); 
        }
        return result;
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

            if(curr.zero == null && curr.one == null) return -1;

            if( (optimumVal == 0 && curr.zero == null ) || (optimumVal == 1 && curr.one == null) ){
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