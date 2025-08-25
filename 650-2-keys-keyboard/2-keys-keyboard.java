class Solution {
    int N;
    public int minSteps(int n) {
        if(n == 1) return 0;
        N = n;
        return 1 + (int) solve(1,1);
    }

    public long solve(int curr, int copied) {
        if (curr == N) return 0;
        if (curr > N) return Integer.MAX_VALUE;

        long copy = Integer.MAX_VALUE, paste = Integer.MAX_VALUE;
        if(curr != copied) copy = 1 + solve(curr, curr);
        paste = 1 + solve(curr + copied, copied);

        return Math.min(copy, paste);
    }
}