class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length, q = queries.length;
        int[][] modQueries = new int[q][3];
        Arrays.sort(nums);

        for(int i=0; i<q; i++) {
            modQueries[i][0] = queries[i][0];
            modQueries[i][1] = queries[i][1];
            modQueries[i][2] = i;
        }

        Arrays.sort(modQueries, (a,b)->(a[1] - b[1]));
        
        Trie prefixTree = new Trie();
        int[] result = new int[q];

        int j = 0;
        boolean isAddedOne = false;
        for(int i=0; i<q;i++) {
            while(j<n && nums[j] <= modQueries[i][1] ) {
                prefixTree.insert(nums[j]);
                isAddedOne = true;
                j++;  
            }
            result[modQueries[i][2]] = !isAddedOne ? -1 : prefixTree.findMaxXOR(modQueries[i][0]);
        } 

        return result;
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

            if(curr == null ) {
                maxXORPossible = maxXORPossible | (bit<<i);
                continue;
            }

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