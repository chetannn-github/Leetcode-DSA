class Solution {
    int n1, n2;
    int[][] dp;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        n1 = nums1.length;
        n2 = nums2.length;

        dp = new int[n1][n2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(nums1,nums2,0,0);
    }

    public int solve(int[] nums1, int[] nums2, int i, int j){
        if(i>=n1 || j>=n2){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int max = 0;
        if(nums1[i] == nums2[j]){
            return dp[i][j] = 1 + solve(nums1, nums2, i+1, j+1);
        }else{
            int opt1 = solve(nums1, nums2, i+1, j+1);
            int opt2 = solve(nums1, nums2, i+1, j);
            int opt3 = solve(nums1, nums2, i, j+1);

            max = Math.max(opt1, Math.max(opt2,opt3));
        } 
        return dp[i][j] = max;
    }
}