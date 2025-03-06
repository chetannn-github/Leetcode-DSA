class Solution {
    int dp[][];
    public int findLongestChain(int[][] nums) {
        dp = new int[nums.length][nums.length];
        Arrays.sort(nums, (a,b)-> a[0] - b[0]);

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
        return solve(nums,-1,0);
    }

    public int solve(int[][] nums, int last, int start){
        if(start >= nums.length){
            return 0;
        }
        if(last!=-1 && dp[start][last] != -1){
            return dp[start][last];
        }
        int taken = 0;
        if(last == -1 || nums[start][0] > nums[last][1]){
            taken = 1 + solve(nums,start, start+1);
        }

        int skip  = solve(nums,last, start+1);

        if(last!=-1){
            dp[start][last] = Math.max(skip, taken);
        }
        return Math.max(skip, taken);
    
    }
}