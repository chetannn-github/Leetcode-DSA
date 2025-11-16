class Solution {
    int[] dp;
    int NOT_VISITED_FLAG = -1;
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3) return 0;

        dp = new int[n+1];
        Arrays.fill(dp,NOT_VISITED_FLAG);

        int start = 0;
        int d = nums[1] - nums[0];
        int length = 2;
        int result = 0;

        for(int end=2; end<n; end++) {
            int currD = nums[end] - nums[end-1];
            if(currD != d) {
                d = currD;
                start = end-1;
                if(length >= 3) result += solve(length);
                length = 2;
            }else {
                length++;
            }
        }
        if(length >= 3) result += solve(length);
        return result;
    }

    private int solve(int n) {
        if(dp[n] != NOT_VISITED_FLAG) return dp[n];
        int result = 0;
        for(int i=3; i<=n; i++) {
            result += n - i + 1;
        }

        return dp[n] = result;
    }
}