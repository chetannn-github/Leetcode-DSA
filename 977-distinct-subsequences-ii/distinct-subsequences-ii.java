//TLE
// class Solution {
//     String s;
//     int n;
//     HashSet<String> hs;
//     public int distinctSubseqII(String s) {
//         this.hs = new HashSet<>();
//         this.n = s.length();
//         this.s = s;
//         solve(0, new StringBuilder());
//         return hs.size() - 1;
//     }

//     private void solve(int currIdx, StringBuilder sb) {
//         if(currIdx >= n) {
//             hs.add(sb.toString());
//             return;
//         }
//         sb.append(s.charAt(currIdx));
//         solve(currIdx+1,sb);
//         sb.setLength(sb.length()-1);

//         solve(currIdx+1,sb);

//     }
// }


class Solution {
    int MOD = 1_000_000_007;
    public int distinctSubseqII(String s) {
        int n = s.length();
        Long[] dp = new Long[n+1];
        int[] prevIdx = new int[26];

        Arrays.fill(prevIdx,-1);
        long result = 0;
        dp[0] = 1L;
        for(int i=1; i<=n; i++) {
            int currChar = s.charAt(i-1) - 'a';
            result =  (2L * dp[i-1]) % MOD;

            if(prevIdx[currChar] != -1) {
                result = ((result -  dp[prevIdx[currChar]] % MOD) + MOD) % MOD;
            }
            dp[i] = result % MOD;
            prevIdx[currChar] = i-1;
        }

        return (int) (((result - 1) % MOD ) + MOD) % MOD;
    }
}
