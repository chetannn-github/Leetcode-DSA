class Solution {
    int[][] matrix;
    int rows, cols;
    Integer[][] dp;
    public int countSquares(int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.dp = new Integer[rows][cols];

        int totalSquares = 0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                totalSquares += solve(i,j);
            }
        }

        return totalSquares;
    }

    private int solve(int x, int y) {
        if(x >= rows || y >= cols) return 0;
        if(matrix[x][y] == 0) return 0;
        if(dp[x][y] != null) return dp[x][y];

        int right = solve(x,y+1);
        int down = solve(x+1,y);
        int diagonal = solve(x+1,y+1);

        return dp[x][y] = 1 + Math.min(right, Math.min(down,diagonal));
    }
}