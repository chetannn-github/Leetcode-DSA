class Solution {
    
    int n;
    int dp[];
    public int deleteAndEarn(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        dp = new int[n];
        Arrays.fill(dp,-1);

        return solve(nums,0);
    }

    public int solve(int[] nums, int start){
        if(start >=n){
            return 0;
        } 

        if(dp[start]!=-1){
            return dp[start];
        }
        int maxPoints = Integer.MIN_VALUE;
        
        for(int i=start; i<n;i++ ){
            if(i>start && nums[i] == nums[i-1]){continue;}

            int points = 0;
            int next = i;
            while(next<n && nums[next]== nums[i]){
                points += nums[next];
                next++;
            }
            

            while(next<n && nums[next]== nums[i]+1){
                next++;
            }

            points += solve(nums,next);  
            maxPoints = Math.max(maxPoints,points);          
        }

        return dp[start] = maxPoints;
    }
}