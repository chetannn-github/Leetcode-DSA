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



import java.util.*;

class Solution {
    int n;
    long[] dp;
    int[] unique;
    Map<Integer, Long> hm = new HashMap<>();

    public long maximumTotalDamage(int[] nums) {
        
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0L) + num);
        }

        n = hm.size();
        unique = new int[n];
        int idx = 0;

        for (int key: hm.keySet()){
            unique[idx] = key;
            idx++;
        }

        Arrays.sort(unique);
        dp = new long[n];
        Arrays.fill(dp, -1);

        return solve(0);
    }

    public long solve(int start) {
        if (start >= n) {
            return 0;
        }

        if (dp[start] != -1){
            return dp[start];
        }

        long skip = solve(start + 1);

        int currNum = unique[start];
        long take = hm.get(currNum);
        int nextidx = start + 1;

        while (nextidx < n && (unique[nextidx] == currNum + 1 || unique[nextidx] == currNum + 2)) {
            nextidx++;
        }

        take += solve(nextidx);

        return dp[start] = Math.max(skip, take);
    }
}

