class Solution {
    public int maxSum(int[][] grid) {
        int maxSum = 0;
        int r = grid.length, c = grid[0].length;

        for(int row=0; row<r-2; row++){
            for(int col=0; col<c-2; col++){
                int sum = grid[row][col] +  grid[row][col+1] + grid[row][col+2] +
                                            grid[row+1][col+1] +
                          grid[row+2][col] + grid[row+2][col+1] + grid[row+2][col+2];

                maxSum = Math.max(maxSum,sum);          
            }
        }
        return maxSum;
        
    }
}