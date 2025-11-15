// MEMORY LIMIT EXCEEDED
// class Solution {
//     int[][][] dp;
//     int NOT_CACHED = -1;
//     int n,halfTotalSum;
//     public int tallestBillboard(int[] rods) { 
//         n = rods.length;
//         int totalSum = sumArray(rods);
//         halfTotalSum = totalSum / 2 ;
        
//         dp = new int[n][halfTotalSum+1][halfTotalSum+1];
       
//         for(int[][] grid : dp) {
//             for(int[] row : grid) Arrays.fill(row,NOT_CACHED);
//         }

//         return solve(rods,0,0,0);
//     }


//     private int solve(int[] arr,int currIdx, int leftSum, int rightSum ) {
//         if(leftSum > halfTotalSum || rightSum > halfTotalSum) return 0;
//         if(currIdx >= n) return leftSum == rightSum ? leftSum : 0;
//         if(dp[currIdx][leftSum][rightSum] != NOT_CACHED) return dp[currIdx][leftSum][rightSum];

//         int result = leftSum == rightSum ? leftSum : 0;

//         int opt1 = solve(arr,currIdx+1,leftSum+arr[currIdx],rightSum);
//         int opt2 = solve(arr,currIdx+1,leftSum,arr[currIdx]+rightSum);
//         int opt3 = solve(arr,currIdx+1,leftSum,rightSum);

//         return dp[currIdx][leftSum][rightSum] = Math.max(opt1,Math.max(opt2,opt3));

//     }

//     public int sumArray(int[] arr) {
//         int sum = 0;
//         for(int num : arr) {
//             sum += num;
//         }
//         return sum;
//     }
// }

// TLE
// class Solution {
//     HashMap<String, Integer> dp;
//     int n, halfTotalSum;

//     public int tallestBillboard(int[] rods) {
//         n = rods.length;
//         int totalSum = sumArray(rods);
//         halfTotalSum = totalSum / 2;
//         dp = new HashMap<>();
//         return solve(rods, 0, 0, 0);
//     }

//     private int solve(int[] arr, int idx, int leftSum, int rightSum) {
//         if (leftSum > halfTotalSum || rightSum > halfTotalSum) return 0;
//         if (idx >= n) return leftSum == rightSum ? leftSum : 0;

//         String key1 = idx + "_" + leftSum + "_" + rightSum;
//         String key2 = idx + "_" +rightSum + "_" + leftSum ;
//         if (dp.containsKey(key1)) return dp.get(key1);
//         if (dp.containsKey(key2)) return dp.get(key2);

//         int opt1 = solve(arr, idx + 1, leftSum + arr[idx], rightSum);
//         int opt2 = solve(arr, idx + 1, leftSum, rightSum + arr[idx]);
//         int opt3 = solve(arr, idx + 1, leftSum, rightSum);

//         int best = Math.max(opt1, Math.max(opt2, opt3));
//         dp.put(key1, best);
//         dp.put(key2, best);
//         return best;
//     }

//     public int sumArray(int[] arr) {
//         int sum = 0;
//         for (int num : arr) sum += num;
//         return sum;
//     }
// }


// MEMORY LIMIT EXCEEDED
class Solution {
    int[][] dp;
    int NOT_CACHED = -1;
    int n,totalSum;
    int offset;
    public int tallestBillboard(int[] rods) { 
        n = rods.length;
        totalSum = sumArray(rods);
        offset = totalSum;
        dp = new int[n][totalSum*2 + 1];
       
        for(int[] row : dp) {
             Arrays.fill(row,NOT_CACHED);
        }

        return solve(rods,0,0) / 2;
    }


    private int solve(int[] arr,int currIdx, int diff ) {
        if(currIdx >= n) return diff == 0 ? 0 : Integer.MIN_VALUE;
        if(dp[currIdx][diff+offset] != NOT_CACHED) return dp[currIdx][diff+offset];


        int opt1 = arr[currIdx] + solve(arr,currIdx+1,diff + arr[currIdx]);
        int opt2 = arr[currIdx] + solve(arr,currIdx+1,diff - arr[currIdx]);
        int opt3 = solve(arr,currIdx+1,diff);

        return dp[currIdx][diff+offset] = Math.max(opt1,Math.max(opt2,opt3));

    }

    public int sumArray(int[] arr) {
        int sum = 0;
        for(int num : arr) {
            sum += num;
        }
        return sum;
    }
}


