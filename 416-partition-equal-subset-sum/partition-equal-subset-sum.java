// class Solution {
//     int totalSum = 0;
//     int n;
//     int dp[][];
//     public boolean canPartition(int[] nums) {
//         n = nums.length;
//         for(int num : nums){
//             totalSum += num;
//         }

//         if(totalSum%2 != 0){
//             return false;
//         }

//         dp = new int[n+1][totalSum +1];

//         for(int row[] : dp){
//             Arrays.fill(row, -1);
//         }
//         return solve(nums,0,0);
//     }

//     public boolean solve(int[] nums, int start,int sum){
        
//         if(2*sum == totalSum){
//             dp[start][sum] =  0 ;
//             return true;
//         }

//         if(2* sum>= totalSum ){
//             dp[start][sum] =  1 ;
//             return false;
//         }

//         if(dp[start][sum]!=-1){
//             return dp[start][sum]== 0? true : false;
//         }
        
//         boolean ans = false;
//         for(int i= start ; i<n; i++){
//             ans =  ans || solve(nums,i+1,sum+nums[i]);
//             if(ans){
//                 return true;
//             }
//         }
//         dp[start][sum] = ans? 0 : 1;
        
//         return ans;
//     }
// }

class Solution {
    int totalSum = 0;
    int n;
    int dp[][];
    public boolean canPartition(int[] nums) {
        n = nums.length;
        for(int num : nums){
            totalSum += num;
        }

        if(totalSum%2 != 0){
            return false;
        }

        dp = new int[n+1][totalSum/2 + 1];

        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        return solve(nums,0,totalSum/2);
    }

    public boolean solve(int[] nums, int start,int target){
        
        if(target==0){
            return true;
        }

        if(start>=n){
            return false;
        }
        

        if(dp[start][target]!=-1){
            return dp[start][target]== 0? true : false;
        }
        
        boolean ans = false;
        
        if(target>= nums[start]) ans =  ans || solve(nums,start+1,target-nums[start]);
        if(ans) {
            dp[start][target] = ans? 0 : 1;
            return true;
        }
        
        ans = ans || solve(nums,start+1,target);
        
        dp[start][target] = ans? 0 : 1;
        
        return ans;
    }
}