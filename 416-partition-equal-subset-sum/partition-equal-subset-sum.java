class Solution {
    int totalSum = 0;
    int n;
    int dp[][];
    public boolean canPartition(int[] nums) {
        n = nums.length;
        for(int num : nums){
            totalSum += num;
        }

        dp = new int[n+1][totalSum+1];

        for(int row[] : dp){
            Arrays.fill(row, -1);
        }

        return solve(nums,0,0);
    }

    public boolean solve(int[] nums, int start,int sum){
        
        if(2*sum == totalSum){
            return true;
        }

        if(dp[start][sum]!=-1){
            return dp[start][sum]== 0? true : false;
        }
        
        boolean ans = false;
        for(int i= start ; i<n; i++){
            ans =  ans || solve(nums,i+1,sum+nums[i]);
            if(ans){
                return true;
            }
        }
        dp[start][sum] = ans? 0 : 1;
        
        return ans;
    }
}