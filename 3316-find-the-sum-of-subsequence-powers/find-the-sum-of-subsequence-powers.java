class Solution {
    int MOD = 1_000_000_007;
    int n,k;
    int[] nums;
    HashMap<Integer,Integer>[][][] dp;
    public int sumOfPowers(int[] nums, int k) {
        Arrays.sort(nums);
        this.nums = nums;
        this.k = k;
        this.n = nums.length;
        this.dp = new HashMap[n][n][k+1];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                for(int l = 0;l<k+1; l++) {
                    dp[i][j][l] = new HashMap<>();
                }
            }
        }
        return solve(-1,0,0,Integer.MAX_VALUE);
    }

    private int solve(int prev, int curr, int added, int minDiff) {
        if(curr >= n) return added == k ? minDiff : 0;
        if(added > k) return 0;
        if(dp[prev+1][curr][added].containsKey(minDiff)) return dp[prev+1][curr][added].get(minDiff);

        int take = 0;
        
        if(prev == -1) {
            take = solve(curr,curr+1,1,minDiff);
        }else {
            take = solve(curr,curr+1,added+1,Math.min(minDiff, Math.abs(nums[prev]-nums[curr])));
        }

        int skip = solve(prev,curr+1,added,minDiff);
        int result = (skip + take) % MOD;
        dp[prev+1][curr][added].put(minDiff,result);
        return result;


    }
}