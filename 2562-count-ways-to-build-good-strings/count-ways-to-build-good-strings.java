class Solution {
    long[] dp;
    int MOD = 1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new long[high + 1];
        Arrays.fill(dp, -1);
        long upperLimit = solve(high, zero, one,0);
        Arrays.fill(dp, -1);
        long lowerLimit = solve(low-1, zero, one,0);
        long res = (upperLimit - lowerLimit + MOD) % MOD;
        return (int) (res % MOD);  
    }

    public long solve(int maxLimit, int zero, int one, int currLength) {
        if(currLength >= maxLimit) return 0;
        if(dp[currLength] != -1) return dp[currLength];

        long addZero = 0, addOne = 0;

        if(currLength + zero <= maxLimit) {
            addZero = 1 + solve(maxLimit,zero, one, currLength + zero);
        }

        if(currLength + one <= maxLimit) {
            addOne = 1 + solve(maxLimit,zero, one, currLength + one);
        }

        long res = (long) (addZero + addOne) % MOD;

        return dp[currLength] = res;
    }
}