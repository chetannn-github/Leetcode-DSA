// class Solution {
//     int[] nums; 
//     int n,k;
//     Long[][][] dp;
//     public long putMarbles(int[] wts, int k) {
//         this.n = wts.length;
//         this.k = k;
//         this.nums = wts;
//         this.dp = new Long[n][k][2];

//         long max = solve(0,0,1);
//         long min = solve(0,0,0);
//         return max - min;
//     }

//     private long solve(int curr, int taken,int max) {
//         long INVALID = max == 1 ? Long.MIN_VALUE : Long.MAX_VALUE;
//         if(curr >= n-1) {
//             return taken == k-1 ? 0L : INVALID;
//         }

//         if(taken == k-1) return 0L;
//         if(dp[curr][taken][max] != null) return dp[curr][taken][max];

//         long remaining = solve(curr+1,taken+1,max);
//         long parition = INVALID;
//         if(remaining != INVALID) {
//             parition = nums[curr] + nums[curr+1] + remaining;
//         }
//         long carryOn = solve(curr+1,taken, max);

//         return dp[curr][taken][max] = max == 1 ? Math.max(parition,carryOn) : Math.min(parition,carryOn);
//     }
// }


class Solution {
    public long putMarbles(int[] wts, int k) {
        int n = wts.length;
        List<Integer> adjPairs = new ArrayList<>();
        for(int i=0; i<n-1; i++) {
            adjPairs.add(wts[i] + wts[i+1]);
        }

        Collections.sort(adjPairs);
        System.out.println(adjPairs);
        long diff = 0; 
        for(int i=0; i<k-1; i++) {
            diff += adjPairs.get(n-2-i) - adjPairs.get(i);
        }
        return diff;
    }

    
}




