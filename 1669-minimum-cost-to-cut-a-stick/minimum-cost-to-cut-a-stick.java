class Solution {
    HashMap<String,Integer> dp;
    int[] cuts;
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        this.cuts = cuts;
        this.dp = new HashMap<>();
        return solve(0,n);
    }

    private int solve(int start, int end) {
        if(end - start == 1) return 0;
        String key = start + " " + end;
        if(dp.containsKey(key)) return dp.get(key);

        int result = Integer.MAX_VALUE;
        for(int i=0; i<cuts.length; i++) {
            int currPos = cuts[i];

            if(currPos >= end || currPos <= start) continue;
            int currResult = end - start + solve(start, currPos) + solve(currPos, end);
            result = Math.min(currResult,result);
        }
        result = result == Integer.MAX_VALUE ? 0 : result;
        dp.put(key,result);
        return result;
    }
}