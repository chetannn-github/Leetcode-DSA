class Solution {
    int N;
    double oneEight = 0.125;
    double[][][] dp;
    public double knightProbability(int n, int k, int row, int col) {
        this.N = n;
        dp = new double[N][N][k+1];

        for(double [][] grid : dp) {
            for(double arr[] : grid) Arrays.fill(arr, -1.0);
        }
        return solve(k, row, col);
    }


    public double solve(int k , int row, int col) {
        if(row < 0 || row >= N || col < 0 || col >= N) {
            return 0.0;
        }

        if(k == 0) return 1.0;
        if(dp[row][col][k] != -1.0) return dp[row][col][k];

        double opt1 = oneEight * solve(k-1 , row-2, col-1);
        double opt2 = oneEight * solve(k-1 , row+2, col-1);
        double opt3 = oneEight * solve(k-1 , row-2, col+1);
        double opt4 = oneEight * solve(k-1 , row+2, col+1);

        double opt5 = oneEight * solve(k-1 , row-1, col-2);
        double opt6 = oneEight * solve(k-1 , row+1, col-2);
        double opt7 = oneEight * solve(k-1 , row-1, col+2);
        double opt8 = oneEight * solve(k-1 , row+1, col+2);


        return dp[row][col][k] = opt1 + opt2 + opt3 + opt4 + opt5 + opt6 + opt7 + opt8;

        
    }
}