class Solution {
    int n;
    int[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        n = days.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(days, costs, 0);
    }

    public int solve(int[] days, int[] costs, int currIdx){
        if(currIdx >= n) return 0;
        if(dp[currIdx] != -1) return dp[currIdx]; 

        int oneDayPass = costs[0] + solve(days, costs, currIdx +1);
        int weekPass = costs[1] + solve(days, costs, bs(days, days[currIdx] + 7));
        int monthPass = costs[2] + solve(days, costs, bs(days, days[currIdx] + 30));

        return dp[currIdx] = Math.min(oneDayPass, Math.min(weekPass, monthPass));

    }


    public int bs(int[] arr, int target) {
        int start = 0, end = arr.length-1;
        int result = arr.length;
        
        while(start <= end) {
            int mid = start + ((end - start)>>1);

            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) start = mid + 1;
            else {
                result = mid;
                end = mid - 1;
            }
        }

        return result;
    }
}