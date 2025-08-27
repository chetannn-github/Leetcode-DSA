// class Solution {
//     private int N;
//     private int[][] dp;
//     private int totalSum = 0;
//     public boolean canPartition(int[] nums) {
//         N = nums.length;
        
//         for(int num : nums) totalSum += num;
//         dp = new int[N][2 * totalSum + 1];

//         for(int[] row : dp) Arrays.fill(row,-1);

//         return solve(nums,0,0);
//     }


//     public boolean solve(int[] nums, int currIdx, int sum) {
//         if(currIdx == N) return sum == 0;
//         if(dp[currIdx][sum + totalSum] != -1) return dp[currIdx][sum + totalSum] == 1;

//         boolean result = false;
//         result = result || solve(nums,currIdx+1, sum + nums[currIdx]);
//         result = result || solve(nums,currIdx+1, sum - nums[currIdx]);

//         dp[currIdx][sum + totalSum] =  result ? 1 : 0;
//         return result;
//     }
// }


class Solution {
    int totalSum = 0;
    int n;
    int dp[][];
    public boolean canPartition(int[] nums) {
        n = nums.length;
        for(int num : nums) totalSum += num;
    
        if(totalSum%2 != 0) return false;

        dp = new int[n+1][totalSum/2 + 1];

        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        return solve(nums,0,totalSum/2);
    }

    public boolean solve(int[] nums, int start,int target){
        // same as combination sum 
        if(target==0){
            return true;
        }

        if(start>=n){
            return false;
        }
    
        if(dp[start][target]!=-1){
            return dp[start][target]== 0? true : false;
        }
        
        boolean result = false;
        
        if(target>= nums[start]) result =  result || solve(nums,start+1,target-nums[start]);
        
        result = result || solve(nums,start+1,target);
        
        dp[start][target] = result? 0 : 1;
        
        return result;
    }
}
