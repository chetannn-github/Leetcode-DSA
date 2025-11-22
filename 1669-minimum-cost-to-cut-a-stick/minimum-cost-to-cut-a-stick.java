// class Solution {
//     HashMap<String,Integer> dp;
//     int[] cuts;
//     public int minCost(int n, int[] cuts) {
//         Arrays.sort(cuts);
//         this.cuts = cuts;
//         this.dp = new HashMap<>();
//         return solve(0,n);
//     }

//     private int solve(int start, int end) {
//         if(end - start == 1) return 0;
//         String key = start + " " + end;
//         if(dp.containsKey(key)) return dp.get(key);

//         int result = Integer.MAX_VALUE;
//         for(int i=0; i<cuts.length; i++) {
//             int cutPos = cuts[i];

//             if(cutPos >= end || cutPos <= start) continue;
//             int currResult = end - start + solve(start, cutPos) + solve(cutPos, end);
//             result = Math.min(currResult,result);
//         }
//         result = result == Integer.MAX_VALUE ? 0 : result;
//         dp.put(key,result);
//         return result;
//     }
// }

class Solution {
    List<Integer> modCuts;
    Integer[][] dp;
    int k;
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        this.k = cuts.length + 2;
        this.dp = new Integer[k][k];
        this.modCuts = new ArrayList<>();

        modCuts.add(0);
        for(int cut : cuts) modCuts.add(cut);
        modCuts.add(n);
        return solve(0,k-1);
    }

    private int solve(int startIdx, int endIdx) {
        if(endIdx - startIdx == 1) return 0;
        if(dp[startIdx][endIdx] != null) return dp[startIdx][endIdx];

        int result = Integer.MAX_VALUE;
        for(int i=startIdx+1; i<endIdx; i++) {
            int start = modCuts.get(startIdx), end = modCuts.get(endIdx);
            int currResult = end - start + solve(startIdx, i) + solve(i, endIdx);
            result = Math.min(currResult,result);
        }
        result = result == Integer.MAX_VALUE ? 0 : result;
        return dp[startIdx][endIdx] = result;
    }
}

            
            
