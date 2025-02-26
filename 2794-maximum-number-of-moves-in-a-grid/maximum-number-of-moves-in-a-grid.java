class Solution {
    int rows, cols;
    int dp[][];
    public int maxMoves(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        dp = new int[rows][cols];
        int moves = 0;

        for(int r[] : dp){
            Arrays.fill(r,-1);
        }

        for(int i=0; i<rows;i++){
            moves = Math.max(solve(grid,i,0), moves) ;
        }

        return moves;
    }


    public int solve(int[][] grid , int i, int j){
        
        // kuki col toh me sbme increase krne wala huu 
        if(j+1 >= cols){
            return 0;
        }

        if(dp[i][j]!= -1){
            return dp[i][j];
        }

        // three options hhh
        int moves = 0;
        
        // (i-1,j+1)
        if(i-1 >=0 && grid[i-1][j+1] > grid[i][j]){
            moves = Math.max(1 + solve(grid,i-1,j+1), moves);
        }


        // (i,j+1)
        if(grid[i][j+1] > grid[i][j]){
            moves = Math.max (1 + solve(grid,i,j+1), moves);
        }
        
        
        // (i+1,j+1)
        if(i+1 < rows && grid[i+1][j+1] > grid[i][j]){ 
            moves = Math.max(1 + solve(grid,i+1,j+1), moves);
        }
        

        return  dp[i][j] = moves;
    }
}