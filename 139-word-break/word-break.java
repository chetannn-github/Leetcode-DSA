// class Solution {
//     int n;
//     int[] dp;
//     HashSet<String> hs;

//     public boolean wordBreak(String s, List<String> wordDict) {
//         n = s.length();
//         dp = new int[n];
//         hs = new HashSet<>();

//         for(String word : wordDict){
//             hs.add(word);
//         }
//         Arrays.fill(dp,-1);
       
//         return solve(s,0) > 0 ? true : false;
//     }

//     public int solve(String s,int start){
//         if(start>=n){
//             return 1;
//         }
//         if(dp[start]!=-1){
//             return dp[start];
//         }
//         int result = 0;
//         for(int i=start; i<n; i++){
//             if(hs.contains(s.substring(start, i+1))){
//                 int next = solve(s,i+1);
//                 result |= next;
//                 if(result == 1) return dp[start] = 1;
//             }
//         }
//         return dp[start] = result;
//     }

// } 



class Solution {
    int n;
    int[][] dp;
    HashSet<String> hs;

    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        dp = new int[n][n];
        hs = new HashSet<>();

        for (String word : wordDict) {
            hs.add(word);
        }

        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(s, 0, 0) ;
    }

    public boolean solve(String s, int start, int curr) {
        if (curr == n)  return (start == n); 
        if (dp[start][curr] != -1) return dp[start][curr] == 1;

        boolean result = false;

        if (hs.contains(s.substring(start, curr + 1))) {
            result |= solve(s, curr + 1, curr + 1);
        }

        result |= solve(s, start, curr + 1);
        dp[start][curr] = result ? 1 : 0;
        return result;
    }
}

  