class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        Trie prefixTree = new Trie();
        List<String> ans = new ArrayList<>();

        for(String word : dictionary) {
            prefixTree.insert(word);
        }

        for(String q : queries) {
            if(prefixTree.findSpecialWord(q,0,q.length(), prefixTree.root,true,true)) {
                ans.add(q);
            }
        }
        return ans;
    }
}

class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }

    void insert (String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if(curr.children.get(ch) == null) {
                curr.children.put(ch, new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        curr.isEndOfWord = true;
    }

    boolean findSpecialWord (String word, int idx, int n,TrieNode curr, boolean firstTime, boolean secondTime) {
        if(idx >= n){
            return true;
        }
        char ch = word.charAt(idx);

        if (curr.children.containsKey(ch)) {
            if (findSpecialWord(word, idx + 1, n, curr.children.get(ch), firstTime, secondTime)) {
                return true;
            }
        }


        if(firstTime){
            for (char key : curr.children.keySet()) {
                if (key != ch) {
                    if (findSpecialWord(word, idx + 1,n, curr.children.get(key), false,true)) {
                        return true;
                    }
                }
            }
        }else if(secondTime){
            for (char key : curr.children.keySet()) {
                if (key != ch) {
                    if (findSpecialWord(word, idx + 1,n, curr.children.get(key), false,false)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class TrieNode {
    HashMap<Character,TrieNode> children;
    boolean isEndOfWord;
    TrieNode () {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}