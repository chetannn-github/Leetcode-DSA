class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie prefixTree = new Trie();
        for(int num : arr1){
            prefixTree.insert(num);
        }
        int ans = 0;
        for(int num : arr2){
            ans = Math.max(prefixTree.countLongestPrefix(num),ans) ;
        }
        return ans;
    }
}

class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }

    void insert(int num) {
        TrieNode curr = root;
        int digits = (int) Math.log10(num) + 1;

        while(digits-- > 0) {
            int MSB = num / (int) Math.pow(10,digits);
            num = num % (int) Math.pow(10,digits);
            
            if(curr.children.get(MSB) == null){
                curr.children.put(MSB,new TrieNode());
            }
            curr = curr.children.get(MSB);
        }
    }

    int countLongestPrefix(int num){
        TrieNode curr = root;
        int count = 0;
        int digits = (int) Math.log10(num) + 1;

        while(digits--> 0) {
            int MSB = num / (int) Math.pow(10,digits);
            num %= (int) Math.pow(10,digits);
            
            if(curr.children.get(MSB) == null){
                return count;
            }
            count++;  
            curr = curr.children.get(MSB);
        }
        return count;
    }
}

class TrieNode {
    HashMap<Integer,TrieNode> children;

    TrieNode() {
        children = new HashMap<>();
    }
}