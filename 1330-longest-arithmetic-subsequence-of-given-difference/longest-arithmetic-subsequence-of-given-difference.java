// class Solution {
//     int n;
//     int[] dp;
//     public int longestSubsequence(int[] arr, int d) {
//         n = arr.length;
//         dp = new int[n];

//         Arrays.fill(dp, -1);
//         int result = 0;
//         for(int i=0; i<n; i++) {
//             result = Math.max(result, 1 + solve(arr, d,i));
//         }

//         return result;
//     }   

//     public int solve(int[] arr, int d, int lastIdx) {
//         if(lastIdx == n) return 0;
//         if(dp[lastIdx] != -1) return dp[lastIdx];

//         int result = 0;
//         for(int i = lastIdx + 1; i<n; i++) {
//             if(arr[i] - arr[lastIdx] == d) {
//                 result = Math.max(result, 1 + solve(arr, d,i));
//             }
//         }


//         return dp[lastIdx] = result;
//     }
// }


class Solution {
    public int longestSubsequence(int[] arr, int d) {
        Map<Integer, Integer> dp = new HashMap<>();
        int result = 1;

        for (int curr : arr) {
            dp.put(curr, dp.getOrDefault(curr - d, 0) + 1);
            result = Math.max(result, dp.get(curr));
        }

        return result;
    }   

    
}