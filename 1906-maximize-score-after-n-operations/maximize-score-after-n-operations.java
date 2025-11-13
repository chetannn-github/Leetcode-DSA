class Solution {
    int n;
    int[] dp;
    public int maxScore(int[] nums) {
        n = nums.length;
        dp = new int[1<<n];
        Arrays.fill(dp,-1);
        return solve(nums,0,1);
    }

    private int solve(int[] nums,int visited, int op) {
        if(visited == (1<<n)-1) return 0;
        if(dp[visited] != -1) return dp[visited];
        int maxScore = 0;

        for(int i=0; i<n-1; i++) {
            if((visited & (1 << i)) != 0) continue;
            for(int j=i+1; j<n; j++) {
                if((visited & (1 << j)) != 0) continue;

                int newVisited = visited | (1 << i) | (1 << j);
                int score = op * hcf(nums[i], nums[j]);
                int totalScore = score + solve(nums,newVisited,op+1);
                maxScore = Math.max(maxScore,totalScore);        
            }
        }

        return dp[visited] = maxScore;
    }

    private int hcf(int a, int b) {
        return b==0 ? a : hcf(b, a%b);
    }
}

