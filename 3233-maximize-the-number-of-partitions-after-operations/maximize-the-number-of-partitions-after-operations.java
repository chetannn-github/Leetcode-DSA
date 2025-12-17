class Solution {
    String s;
    int k,n;
    HashMap<Integer,Integer>[][] dp;
    public int maxPartitionsAfterOperations(String s, int k) {
        this.s = s;
        this.k = k;
        this.n = s.length();
        this.dp = new HashMap[n][2];
        for(int i=0; i<n; i++) {
            dp[i][0] = new HashMap<>();
            dp[i][1] = new HashMap<>();
        }
        return solve(0,0,0);
    }

    private int solve(int curr, int unique, int change) {
        if(curr >= n) return 1;
        if(dp[curr][change].containsKey(unique)) return dp[curr][change].get(unique);

        int uniqueCount = oneCount(unique);
        int result = 0;

        
        if(change == 0) {
            for(int i=0; i<26; i++) {
                int newUnique = (unique | (1<<i));
                if(oneCount(newUnique) > k) {
                    result = Math.max(result,1 + solve(curr+1,1<<i,1));
                }else result = Math.max(result, solve(curr+1,newUnique,1));
                
            }
        }

        int currChar = (int) s.charAt(curr) - 'a';
        int newUnique = (unique | (1<<currChar));
        if(oneCount(newUnique) > k) {
            result = Math.max(result,1 + solve(curr+1,1<<currChar,change));
        }else result = Math.max(result, solve(curr+1,newUnique,change));

        dp[curr][change].put(unique,result);
        return result;
    }

    private int oneCount(int num) {
        int result = 0;
        while(num > 0) {
            result += (num & 1);
            num >>= 1;
        }

        return result;
    }
}