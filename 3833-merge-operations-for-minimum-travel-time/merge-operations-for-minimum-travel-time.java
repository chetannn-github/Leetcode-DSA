// class Solution {
//     int[] position,time;
//     int n,l;
//     int INVALID = Integer.MAX_VALUE;
//     int NOT_CACHED = -1;
//     int[][][] dp;
//     public int minTravelTime(int l, int n, int k, int[] position, int[] time) {
//         this.n = time.length;
//         this.l = l;
//         this.position = position;
//         this.time = time;
//         this.dp = new int[n][n][k+1];

//         for(int[][] grid : dp) {
//             for(int[] row : grid) Arrays.fill(row,NOT_CACHED);
//         }

//         return solve(0,1,k);
//     }

//     private int solve(int startIdx,int currIdx, int leftMerges) {
//         if(currIdx >= n || leftMerges < 0) return leftMerges == 0 ? 0 : INVALID;
//         if(dp[startIdx][currIdx][leftMerges] != NOT_CACHED) return dp[startIdx][currIdx][leftMerges];

//         int merge = INVALID;
//         int skip = INVALID;

//         if(currIdx+1 < n) {
//             time[currIdx+1] += time[currIdx];
//             merge = solve(startIdx,currIdx+1,leftMerges-1);
//             time[currIdx+1] -= time[currIdx];
//         }

//         int remainingSkipResult = solve(currIdx,currIdx+1,leftMerges);
//         if(remainingSkipResult != INVALID) {
//             skip =  (position[currIdx] - position[startIdx]) * time[startIdx] + remainingSkipResult;
//         }
        

//         return Math.min(merge,skip);
//     }
    
// }

class Solution {
    int[] position,time,prefixTime;
    int n,l;
    int INVALID = Integer.MAX_VALUE;
    int NOT_CACHED = -1;
    int[][][][] dp;
    public int minTravelTime(int l, int n, int k, int[] position, int[] time) {
        this.n = time.length;
        this.l = l;
        this.position = position;
        this.time = time;
        this.dp = new int[n][n][k+1][n];
        this.prefixTime = computePrefixSum(time);
        
        for(int[][][] space : dp) {
            for(int[][] grid : space) {
                for(int[] row : grid) Arrays.fill(row,NOT_CACHED);
            }
        }

        return solve(0,1,k,0);
    }

    private int solve(int startIdx,int currIdx, int leftMerges, int posIdx) {
        if(currIdx >= n || leftMerges < 0) return leftMerges == 0 ? 0 : INVALID;
        if(dp[startIdx][currIdx][leftMerges][posIdx] != NOT_CACHED) return dp[startIdx][currIdx][leftMerges][posIdx];

        int merge = INVALID;
        int skip = INVALID;

        if(currIdx+1 < n) {
            merge = solve(startIdx,currIdx+1,leftMerges-1,posIdx);
        }

        int remainingSkipResult = solve(currIdx,currIdx+1,leftMerges,startIdx+1);
        if(remainingSkipResult != INVALID) {
            skip =  (position[currIdx] - position[startIdx]) * (prefixTime[startIdx+1] - prefixTime[posIdx])+ remainingSkipResult;
        }
        
        return dp[startIdx][currIdx][leftMerges][posIdx] = Math.min(merge,skip);
    }

    public int[] computePrefixSum(int[] nums) {
        int n = nums.length;
        int[] pref = new int[n+1];
    
        for(int i = 1; i <= n; i++) {
            pref[i] = pref[i - 1] + nums[i-1];
        }
        return pref;
    }
    
}