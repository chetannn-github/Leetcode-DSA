class Solution {
    List<String> result = new ArrayList<>();
    String s;
    StringBuilder tempResult = new StringBuilder();
    HashSet<String> wordSet = new HashSet<>();
    int n;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.n = s.length();
        buildListToSet(wordDict);
        solve(0,new StringBuilder());
        return result;
    }

    private void solve(int curr, StringBuilder temp) {
        String currStr = temp.toString();
        if(curr >= n) {
            if(wordSet.contains(currStr)) {
                result.add(new String(tempResult.toString() + currStr));
            }
            return;
        }
        
        if(wordSet.contains(currStr)) {
            int currSize = tempResult.length();
            tempResult.append(currStr+" ");
            solve(curr, new StringBuilder());
            tempResult.setLength(currSize);
        }

        solve(curr+1,temp.append(s.charAt(curr)));
    }

    private void buildListToSet(List<String> list) {
        for(String str : list) wordSet.add(str);
    }
}