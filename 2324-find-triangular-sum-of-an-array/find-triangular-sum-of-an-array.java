class Solution {
    public int triangularSum(int[] prev) {
        int n = prev.length;
        int result = 0;

        int[] curr = new int[n];

        int totalOps = n - 1;
        int ops = 1;

        while(totalOps--> 0) {
            for(int i=0; i<n-ops; i++) {
                curr[i] = (prev[i] + prev[i+1]) % 10;
            }
            prev = curr;
            ops++;
        }

        return prev[0];
    }
}