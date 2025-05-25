class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] combined = new int[n][2];

        for(int i=0; i<n; i++) {
            combined[i] = new int[] {difficulty[i],profit[i]};
        }
        Arrays.sort(combined,(a,b)->(a[0] - b[0]));
        int maxProfit = combined[0][1];
        for(int i=0; i<n; i++) {
            maxProfit = Math.max(maxProfit,combined[i][1]);
            combined[i][1] = maxProfit;
        }
        int profitSum = 0;
        for(int i=0; i< worker.length; i++) {
            int idxOfWork = bs(combined,worker[i]);
            if(idxOfWork != -1 ){
                profitSum += combined[idxOfWork][1];
            }
        }
        
        return profitSum;

    }

    public int bs(int[][] grid, int target) {
        int start = 0, end = grid.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            
            if(grid[mid][0] <= target) {
                ans = mid;
                start = mid + 1;
            }else {
                end = mid -1;
            }
        }

        return ans;
    }
}