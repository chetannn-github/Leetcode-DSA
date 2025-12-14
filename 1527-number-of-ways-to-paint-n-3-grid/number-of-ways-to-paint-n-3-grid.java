class Solution {
    int MOD = 1_000_000_007;
    int m,n,k;
    Integer[][] dp;
    List<Integer> options = new ArrayList<>();
    public int numOfWays(int n) {
        int m = 3;
        this.m = m;
        this.n = n;
        
        getOptions(m);
        this.k = options.size();
        this.dp = new Integer[k+1][n+1];
        return solve(-1,0);
    }

    private int solve(int prev, int taken) {
        if(taken == n) return 1;
        if(dp[prev+1][taken] != null) return dp[prev+1][taken];

        int result = 0;
        for(int i=0; i<k; i++) {
            if(prev != -1 && i== prev ) continue;

            if(isPossible(prev,i)) {
                result = (result + solve(i,taken+1)) % MOD;
            }
        }

        return dp[prev+1][taken] = result;
    }

    private boolean isPossible(int prev, int curr) {
        if(prev == -1) return true;

        Integer prevOpt = options.get(prev);
        Integer currOpt = options.get(curr);

        while(prevOpt > 0) {
            int prevLast = prevOpt % 10;
            int currLast = currOpt % 10;
            if(prevLast == currLast) return false;

            prevOpt /= 10;
            currOpt /= 10;
        }

        return true;
    }

    private void getOptions(int cols) {
        for(int i=1; i<=3; i++) {
            optionsHelper(i,cols);
        }   
    }

    private void optionsHelper(int curr, int totalDigits) {
        int currDigits = (int) Math.log10(curr) + 1;

        if(currDigits == totalDigits) {
            options.add(curr);
            return;
        }

        for(int i=1; i<=3; i++) {
            int prevDigit = curr % 10;
            if(prevDigit == i) continue;
            optionsHelper(curr*10+i,totalDigits);
        } 
    }
}
