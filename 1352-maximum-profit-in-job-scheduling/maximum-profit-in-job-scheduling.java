class Solution {
    int[] dp;
    public int jobScheduling(int[] start, int[] end, int[] profit) {
        int n = profit.length;
        int[][] grid = toSortedGrid(start, end, profit, n);
        dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(grid,0, n);
    }

    private int solve(int[][] grid, int curr, int n) {
        if(curr >= n) return 0;
        if(dp[curr] != -1) return dp[curr];

        int skip = solve(grid, curr + 1, n);
        int nextIdx = bs(grid,curr+1,n-1, grid[curr][1]);
        int take = grid[curr][2] + solve(grid, nextIdx, n);

        return dp[curr] = Math.max(take,skip);

    }

    private int bs(int[][] grid, int start, int end, int target) {
        int result = end + 1;
        while(start <= end) {
            int mid = start + ((end - start) >> 1);

            if(grid[mid][0] >= target) {
                result = mid;
                end = mid -1;
            }else {
                start = mid + 1;
            }
        }

        return result;
    }
    
    private int[][] toSortedGrid(int[] arr1, int[] arr2, int[] arr3, int n) {
        int[][] grid = new int[n][3];

        for(int i=0; i<n; i++) {
            grid[i][0] = arr1[i];
            grid[i][1] = arr2[i];
            grid[i][2] = arr3[i];
        }

        Arrays.sort(grid, (a,b)->(a[0] - b[0]));

        return grid;
    }
}