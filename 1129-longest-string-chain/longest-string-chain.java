// class Solution {
//     int n;
//     int dp[];

//     public int longestStrChain(String[] words) {
//         n = words.length;
//         int max = 1;
//         dp = new int[n];
//         Arrays.fill(dp,-1);

//         for(int i=0; i<n; i++){
//             max = Math.max(1+ solve(words,i),max);
//         }
        
//         return max; 
//     }

//     public int solve(String[] words, int  start){
//         if(dp[start]!= -1){
//             return dp[start];
//         }
//         int maxLength = 0;
//         for(int i= 0; i<n; i++){
//             if(i == start) continue;
            
//             if(checkPossibleNext(words,start,i)){
//                 maxLength = Math.max(1 + solve(words, i),maxLength);
//             }
//         }
//         return dp[start] = maxLength;
//     }

//     public boolean checkPossibleNext(String[] words, int prev, int next){
//         int l1 = words[prev].length();
//         int l2 = next.length();

//         if(l1 >= l2 || l2-l1 >1){
//             return false;
//         }
//         boolean EkMaafi = true;
//         int j = 0;

//         for(int i=0; i<l2 && j<l1; i++){
//             if(words[next].charAt(i) == words[prev].charAt(j)){
//                 j++;
//             }else if(words[next].charAt(i) != words[prev].charAt(j) &&  EkMaafi){
//                 EkMaafi = false;
//             }else{
//                 return false;
//             }
//         }
        

//         return true;

//     }
// }



class Solution {
    int n;
    int[][] dp;

    public int longestStrChain(String[] words) {
        n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(words, 0, -1);
    }

    public int solve(String[] words, int start, int last) {
        if (start >= n) return 0;

        if (last != -1 && dp[start][last] != -1) return dp[start][last];
        if(last != -1 && words[start].length() - words[last].length() >=2) return 0;

        int skip = solve(words, start + 1, last);

        int take = 0;
        if (last == -1 || checkPossibleNext(words[last], words[start])) {
            take = 1 + solve(words, start + 1, start);
        }

        if(last != -1) {
            dp[start][last] = Math.max(take, skip);
        }

        return Math.max(take, skip);
    }

    public boolean checkPossibleNext(String prev, String next){
        int l1 = prev.length();
        int l2 = next.length();

        if(l1 >= l2 || l2-l1 >1){
            return false;
        }
        boolean EkMaafi = true;
        int j = 0;

        for(int i=0; i<l2 && j<l1; i++){
            if(next.charAt(i) == prev.charAt(j)){
                j++;
            }else if(next.charAt(i) != prev.charAt(j) &&  EkMaafi){
                EkMaafi = false;
            }else{
                return false;
            }
        }
        

        return true;

    }
}
