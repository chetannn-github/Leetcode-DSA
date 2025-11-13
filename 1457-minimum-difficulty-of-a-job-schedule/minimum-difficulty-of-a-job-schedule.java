class Solution {
    int[][] dp;
    public int minDifficulty(int[] jobDiff, int d) {
        int n = jobDiff.length;
        if(n < d) return -1;
        if(n == d) return sumOfArray(jobDiff);

        dp = new int[n][d];

        for(int[] row : dp) Arrays.fill(row,-1);
        
        return solve(jobDiff,n,d,0,0);
    }

    private int solve(int[] arr, int n, int d, int currIdx, int currDay) {
        if(dp[currIdx][currDay] != -1) return dp[currIdx][currDay];
        if(currDay == d-1) return findMaxFromIndex(arr,currIdx);
        if(currIdx >= n) return Integer.MAX_VALUE;

        int minScore = Integer.MAX_VALUE;
        int maxVal = arr[currIdx];

        for(int i = currIdx; i<n-1; i++) {
            int remaining = solve(arr,n,d,i+1, currDay+1);
            if(remaining != Integer.MAX_VALUE) {
                maxVal = Math.max(maxVal,arr[i]);
                int score = maxVal + remaining;
                minScore = Math.min(minScore,score);
            }
        }

        return dp[currIdx][currDay] = minScore;
    }


    private int sumOfArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    static int findMaxFromIndex(int[] arr, int index) {
        int max = arr[index];
        for(int i = index+1; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

}