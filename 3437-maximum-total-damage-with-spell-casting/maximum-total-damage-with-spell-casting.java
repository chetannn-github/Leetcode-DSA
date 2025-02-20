// class Solution {
//     int n;
//     long dp[];
//     HashMap<Integer,Long> hm = new HashMap<>();

//     public long maximumTotalDamage(int[] nums) {
//         n = nums.length;
//         Arrays.sort(nums);
//         dp = new long[n];
//         Arrays.fill(dp,-1);

//         for (int num : nums) {
//             hm.put(num, hm.getOrDefault(num, 0L) + num);
//         }

//         return solve(nums,0);
//     }

//     public long solve(int[] nums, int start){
//         if(start >=n){
//             return 0;
//         } 

//         if(dp[start]!=-1){
//             return dp[start];
//         }
//         long maxPoints = Integer.MIN_VALUE;
        
//         for(int i=start; i<n;i++ ){
//             if(i>start && nums[i] == nums[i-1]){continue;}

//             long points = hm.get(nums[i]);
//             int next = i;
//             while(next<n && nums[next] == nums[i]){
//                 next++;
//             }
            

//             while(next<n && (nums[next]== nums[i]+1 || nums[next]== nums[i]+2)){
//                 next++;
//             }

//             points += solve(nums,next);  
//             maxPoints = Math.max(maxPoints,points);          
//         }

//         return dp[start] = maxPoints;
//     }
// }


class Solution {
    int n;
    long[] dp;
   

    public long maximumTotalDamage(int[] nums) {
        n = nums.length;
        
        Arrays.sort(nums);
        dp = new long[n];
        Arrays.fill(dp, -1);

        return solve(nums,0);
    }

    public long solve(int[] nums, int start){
        if(start>=n){
            return 0;
        }


        if(dp[start]!= -1){
            return dp[start];
        }
        
        // choice one  --> skip
        

        // choice one  --> use it
        int validity = nums[start]+3;
        int j = start;
        long opt2 = 0;

        while(j<n && nums[j] == nums[start]){
            opt2 += nums[start];
            j++;
        }
        long opt1 = solve(nums, j);

        while(j<n && nums[j]<validity){
            j++;
        }

        opt2 += solve(nums,j);
       
        return dp[start] =  Math.max(opt1,opt2);
        
    }
}

