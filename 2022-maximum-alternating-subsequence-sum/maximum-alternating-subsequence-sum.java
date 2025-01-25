class Solution {
    int n;
    long dp[][];
    public long maxAlternatingSum(int[] nums) {
        
        List<Integer> temp = new ArrayList<>();
        n = nums.length;
        dp = new long[n][2];
        for(long[] row : dp){
            Arrays.fill(row,-1);
        }
        int isAdd = 1;
        return solve(nums,0,isAdd);
    }


    public long solve(int[] nums,int start,int isAdd){
        if(start >=n){
            return 0;
        }
        if(dp[start][isAdd] != -1){
            return dp[start][isAdd];
        }
        long taken;

        if(isAdd ==1){
            taken = nums[start] + solve(nums, start+1,0);
        }else{
            taken = -nums[start] + solve(nums, start+1,1);
        }
       
       
        long notTaken = 0 + solve(nums, start+1,isAdd);

        return dp[start][isAdd] = Math.max(notTaken, taken);
    }
}