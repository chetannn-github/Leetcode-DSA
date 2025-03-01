class Solution {
    public int maxSum(int[][] grid) {
        int maxSum = -1;

        for(int row=0;row<grid.length-2;row++){
            for(int col=0;col<grid[0].length-2;col++){
                int sum = grid[row][col] +  grid[row][col+1] + grid[row][col+2] +
                                            grid[row+1][col+1] +
                          grid[row+2][col] + grid[row+2][col+1] + grid[row+2][col+2];

                maxSum = Math.max(maxSum,sum);          
            }
        }

        return maxSum;
        
    }
}