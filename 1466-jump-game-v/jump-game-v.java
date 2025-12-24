class Solution {
    int[] arr;
    int d,n;
    Integer[] dp;
    public int maxJumps(int[] arr, int d) {
        this.d = d;
        this.n = arr.length;
        this.arr = arr;
        this.dp = new Integer[n];
        int maxIndices = 0;

        for(int i=0; i<n; i++) {
            maxIndices = Math.max(maxIndices,solve(i));
        }
        return 1 + maxIndices;
    }

    private int solve(int curr) {
        if(dp[curr] != null) return dp[curr];

        int result = 0;
        int left = Math.max(0,curr-d);
        int right = Math.min(n-1,curr+d);

        for(int i=curr-1; i>= left; i--) {
            if(i<0 || arr[i] >= arr[curr]) break;

            result = Math.max(result,1+solve(i));
        }

        for(int i=curr+1; i<=right; i++) {
            if(i>=n || arr[i] >= arr[curr]) break;
        
            result = Math.max(result,1+solve(i));
        }

        return dp[curr] = result;
        
    }
}