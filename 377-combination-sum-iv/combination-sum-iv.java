// class Solution {
//     int result= 0;
    

//     public int combinationSum4(int[] nums, int target) {
//         solve(nums,target);
    
//         return result;
//     }

//     public void solve(int[] nums, int target){
//         if(target==0){
//             result++;
//             return;
//         }else if(target<0){
//             return ;
//         }
        

//         for(int num : nums){
//             solve(nums,target-num);            
//         }

//         return ;
//     }
// }

class Solution {
    int[] dp = new int[1001];

    public int combinationSum4(int[] nums, int target) {
        Arrays.fill(dp, -1); 
        return solve(nums, target);
    }

    public int solve(int[] nums, int target) {
        if (target == 0) {
            return 1; 
        } else if (target < 0) {
            return 0; 
        }

        if (dp[target] != -1) {
            return dp[target];
        }

        int total = 0;
        for (int num : nums) {
            total += solve(nums, target - num);
        }

        dp[target] = total;
        return total;
    }
}
