class Solution {
    int n;
    int dp[];
    public int deleteAndEarn(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(nums,0);
    }

    

    public int solve(int[] nums, int start){
        if(start>=n){
            return 0;
        }
        if(dp[start]!= -1){
            return dp[start];
        }
        
        // choice one  --> skip
        int opt1 = solve(nums, start+1);

        // choice one  --> use it
        int validity = nums[start]+2;
        int j = start;
        int opt2 = 0;

        while(j<n && nums[j] == nums[start]){
            opt2 += nums[start];
            j++;
        }
        while(j<n && nums[j]<validity){
            j++;
        }

        opt2 += solve(nums,j);
       

        

        return dp[start] =  Math.max(opt1,opt2);
        
    }
}

