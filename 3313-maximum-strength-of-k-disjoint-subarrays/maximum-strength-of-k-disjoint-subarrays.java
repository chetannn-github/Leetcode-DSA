// TLE
// class Solution {
//     int[] nums, prefixNums;
//     int k, N;
//     long INVALID = Long.MIN_VALUE;
//     HashMap<Integer, Long>[][] dp;

//     public long maximumStrength(int[] nums, int k) {
//         this.nums = nums;
//         this.k = k;
//         this.N = nums.length;
//         this.prefixNums = computePrefixSum(nums);

//         dp = new HashMap[N][N];
//         for (int currIdx = 0; currIdx < N; currIdx++) {
//             for (int j = 0; j < N; j++) {
//                 dp[currIdx][j] = new HashMap<>();
//             }
//         }

//         return solve(0, 0, k);
//     }

//     private long solve(int startIdx, int currIdx, int setNumber) {
//         if (currIdx >= N) return setNumber == 0 ? 0 : INVALID;
//         if (setNumber == 0) return 0;

//         if (dp[startIdx][currIdx].containsKey(setNumber))
//             return dp[startIdx][currIdx].get(setNumber);

//         long carryOn = solve(startIdx, currIdx + 1, setNumber);
//         long parition = INVALID;
//         long remainingPart = solve(currIdx + 1, currIdx + 1, setNumber - 1);

//         if (remainingPart != INVALID) {
//             long sum = prefixNums[currIdx + 1] - prefixNums[startIdx];
//             long sign = ((setNumber & 1) == 0) ? -1 : 1;
//             parition = sum * setNumber * sign + remainingPart;
//         }

//         long skip = solve(currIdx + 1, currIdx + 1, setNumber);
//         long ans = Math.max(skip, Math.max(carryOn, parition));

//         dp[startIdx][currIdx].put(setNumber, ans);
//         return ans;
//     }

//     private int[] computePrefixSum(int[] nums) {
//         int n = nums.length;
//         int[] pref = new int[n + 1];
//         for (int currIdx = 1; currIdx <= n; currIdx++) {
//             pref[currIdx] = pref[currIdx - 1] + nums[currIdx - 1];
//         }
//         return pref;
//     }
// }


import java.util.*;

class Solution {
    int[] nums;
    int k, N;
    long INVALID = (long)-1e18;
    long[][][] dp;

    private long solve(int currIdx, int setNumber, boolean startNew) {
        if(setNumber == 0) return 0;
        if(currIdx >= N) return INVALID;
        int flag = startNew ? 1 : 0;
        if(dp[currIdx][setNumber][flag] != INVALID)return dp[currIdx][setNumber][flag];
        

        long notTake = INVALID;
        long take = INVALID;
        
        if(startNew) {
            notTake = solve(currIdx + 1, setNumber, true);
        }
        
        long multiplyFactor = ((setNumber&1) != 0) ? setNumber : -setNumber;
        take = solve(currIdx + 1, setNumber, false) + nums[currIdx] * multiplyFactor;
        take = Math.max(take, solve(currIdx + 1, setNumber - 1, true) + nums[currIdx] * multiplyFactor);
    
        return dp[currIdx][setNumber][flag] = Math.max(notTake, take);
    }

    public long maximumStrength(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        this.N = nums.length;

        dp = new long[N + 1][k + 1][2];

        for (int currIdx = 0; currIdx <= N; currIdx++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(dp[currIdx][j], INVALID);
            }
        }

        return solve(0, k, true);
    }
}

