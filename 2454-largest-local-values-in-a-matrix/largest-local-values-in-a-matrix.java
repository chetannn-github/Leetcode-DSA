class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int ans[][] = new int[n-2][n-2];


        for(int i=1; i<n-1; i++){
            for(int j=1;j<n-1; j++){
                int r1 = i-1;
                int c1= j-1;

                int r2 = i+1;
                int c2 = j+1;
                int max = Integer.MIN_VALUE;
                for(int p=r1 ; p<=r2; p++){
                    for(int q = c1; q<=c2; q++){
                        max = Math.max(max,grid[p][q]);
                    }
                }
                ans[i-1][j-1] = max;
            }
           
        }
        return ans;
    }
}