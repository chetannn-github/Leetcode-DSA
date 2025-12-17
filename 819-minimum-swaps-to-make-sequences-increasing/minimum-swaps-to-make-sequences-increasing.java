class Solution {
    int[] nums1, nums2;
    int n;
    Integer[][] dp;

    public int minSwap(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.n = nums1.length;
        this.dp = new Integer[n][2];

        return Math.min(solve(1, 0), 1 + solve(1, 1));
    }

    private int solve(int curr, int swapped) {
        if (curr == n) return 0;
        if (dp[curr][swapped] != null) return dp[curr][swapped];

        int prev1 = nums1[curr - 1];
        int prev2 = nums2[curr - 1];

        if(swapped == 1) {
            prev1 ^= prev2;
            prev2 ^= prev1;
            prev1 ^= prev2;
        }

        int ans = Integer.MAX_VALUE;

        if(prev1 < nums1[curr] && prev2 < nums2[curr]) {
            ans = solve(curr + 1, 0);
        }

        if(prev1 < nums2[curr] && prev2 < nums1[curr]) {
            ans = Math.min(ans, 1 + solve(curr + 1, 1));
        }

        return dp[curr][swapped] = ans;
    }
}
