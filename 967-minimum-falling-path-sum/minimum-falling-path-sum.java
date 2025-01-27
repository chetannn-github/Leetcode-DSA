class Solution {
    int r;
    int c;
    int dp[][];
    public int minFallingPathSum(int[][] matrix) {
        r = matrix.length;
        c = matrix[0].length;
        dp = new int[r][c];

        for(int[] row : dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        int min = Integer.MAX_VALUE;
        for(int j=0; j<c; j++){
            min = (int) Math.min(solve(matrix,0,j), min);
        } 
        return  min;
    }

    public int solve(int[][] matrix,int i, int j){
        if(i==r-1){
            return matrix[i][j];
        }

        if(dp[i][j] !=Integer.MAX_VALUE ){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        
        
        // row+1,col-1 (left diagonal)
        if(i+1<r && j-1>=0){
            int opt1 = matrix[i][j] + solve(matrix,i+1,j-1);
            ans = Math.min(ans,opt1);
        }
        // row+1,c (down)
        if(i+1<r){
            int opt2 =  matrix[i][j] + solve(matrix,i+1,j);
            ans = Math.min(ans,opt2);
        }
        // row+1, col+1(right diagonal)
        if(i+1<r && j+1<c){
            int opt3 =  matrix[i][j] + solve(matrix,i+1,j+1);
            ans = Math.min(ans,opt3);
        }

        return  dp[i][j] = ans;
    }
}