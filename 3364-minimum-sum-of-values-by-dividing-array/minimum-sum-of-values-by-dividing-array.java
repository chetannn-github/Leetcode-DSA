// TIME LIMIT EXCEED
// class Solution {
//     int[][] dp;
//     int INVALID = Integer.MAX_VALUE;
//     int[] cumANDCache;
//     public int minimumValueSum(int[] nums, int[] andValues) {
//         int n = nums.length;
//         int m = andValues.length;
//         dp = new int[n][m];

//         cumANDCache = new int[n]; 
//         preComputeANDFromIdx(nums);


//         for(int[] row : dp) Arrays.fill(row,-1);
//         int result = solve(nums,andValues,n,m,0,0);
//         return result == INVALID ? -1 : result;
//     }

//     private int solve(int[] arr, int[] andValues, int n, int m, int currIdx, int andIdx) {
//         if(currIdx >= n) return INVALID;
//         if(andIdx == m-1) return dp[currIdx][andIdx] = (cumANDCache[currIdx] == andValues[andIdx]) ? arr[n-1] : INVALID;
//         if(dp[currIdx][andIdx] != -1) return dp[currIdx][andIdx];

//         int minScore = INVALID;
//         int cumAND = arr[currIdx];

//         for(int i = currIdx; i<n-1; i++) {
//             cumAND &= arr[i];
//             if(cumAND == andValues[andIdx]) {
//                 int remaining = solve(arr,andValues,n,m,i+1, andIdx+1);
//                 if(remaining != INVALID) {
//                     int score = arr[i] + remaining;
//                     minScore = Math.min(minScore,score);
//                 }
//             }else if(cumAND < andValues[andIdx]) break;
            
//         }

//         return dp[currIdx][andIdx] = minScore;
//     }

//     private void preComputeANDFromIdx(int[] arr) {
//         int n = arr.length;
//         int cumAND = arr[n-1];
//         for(int i = n-1; i>=0; i--) {
//             cumAND &= arr[i];
//             cumANDCache[i] = cumAND;
//             if(cumAND == 0) break;
//         }
//         return ;
//     }

// }


class Solution {
    HashMap<Integer,Integer>[][] dp ;
    int INVALID = Integer.MAX_VALUE;
    int[] cumANDCache;
    int MAX_AND = (1<<31) - 1;
    public int minimumValueSum(int[] nums, int[] andValues) {
        int n = nums.length;
        int m = andValues.length;
        dp = new HashMap[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) dp[i][j] = new HashMap<>();
        }

        cumANDCache = new int[n]; 
        preComputeANDFromIdx(nums);

        int result = solve(nums,andValues,n,m,0,0,MAX_AND);
        return result == INVALID ? -1 : result;
    }

    private int solve(int[] arr, int[] andValues, int n, int m, int currIdx, int andIdx, int cumAND) {
        if(currIdx >= n) return INVALID;
        if(dp[currIdx][andIdx].containsKey(cumAND)) return dp[currIdx][andIdx].get(cumAND);

        if(andIdx == m-1) {
            dp[currIdx][andIdx].put(cumAND,(cumANDCache[currIdx] == andValues[andIdx]) ? arr[n-1] : INVALID);
            return dp[currIdx][andIdx].get(cumAND);
        }
        

        int minScore = INVALID;

        if((cumAND & arr[currIdx]) == andValues[andIdx]) {
            int remaining = solve(arr,andValues,n,m,currIdx+1, andIdx+1,MAX_AND);
            if(remaining != INVALID) {
                int score = arr[currIdx] + remaining;
                minScore = Math.min(minScore,score);
            }
        }

        int take = solve(arr,andValues,n,m,currIdx+1,andIdx,cumAND&arr[currIdx]);
        minScore =  Math.min(minScore,take);

        dp[currIdx][andIdx].put(cumAND,minScore);
        return minScore;
    }

    private void preComputeANDFromIdx(int[] arr) {
        int n = arr.length;
        int cumAND = arr[n-1];
        for(int i = n-1; i>=0; i--) {
            cumAND &= arr[i];
            cumANDCache[i] = cumAND;
            if(cumAND == 0) break;
        }
        return ;
    }

}



