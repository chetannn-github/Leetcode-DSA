class Solution {
    List<Integer> stick;
    HashMap<String,Integer> dp;
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        this.stick = new ArrayList<>();
        int k = cuts.length + 2;
        this.dp = new HashMap<>();
        stick.add(0);
        for(int cut : cuts) stick.add(cut);
        stick.add(n);

        return solve(0,n);
    }

    private int solve(int start, int end) {
        if(end - start == 1) return 0;
        String key = start + " " + end;
        if(dp.containsKey(key)) return dp.get(key);

        int result = Integer.MAX_VALUE;
        for(int i=0; i<stick.size(); i++) {
            int currPos = stick.get(i);
            if(currPos >= end || currPos <= start) continue;
            int cost = end - start; 
            int leftCost = solve(start, currPos);
            int rightCost = solve(currPos, end);
            int currResult = cost + leftCost + rightCost;
            result = Math.min(currResult,result);
        }
        result = result == Integer.MAX_VALUE ? 0 : result;
        dp.put(key,result);
        return result;
    }
}