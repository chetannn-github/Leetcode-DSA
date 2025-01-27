class Solution {
    int r;
    int c;
    public int getMaximumGold(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        int maxGold = 0;
        for(int i=0; i<r;i++){
            for(int j=0; j<c; j++){
                maxGold = Math.max(maxGold, solve(grid,i,j));
            }
        }

        return maxGold;
    }

    public int solve(int[][] grid, int i, int j){
        if(i<0 || i>=r || j<0 || j>=c ||grid[i][j]==0){
            return 0;
        }
        int gold = 0;
        int temp = grid[i][j];
        
        // right
        grid[i][j] = 0;
        int right = solve(grid,i,j+1) + temp;
        grid[i][j]= temp;
        
        // left
        grid[i][j] =0;
        int left = solve(grid,i,j-1)+ temp;
        grid[i][j]= temp;
        
        // down 
        grid[i][j] =0;
        int down = solve(grid,i+1,j)+ temp;
        grid[i][j]= temp;

        // up
        grid[i][j] =0;
        int up = solve(grid,i-1,j)+ temp;
        grid[i][j]= temp;
        
        gold = Math.max( Math.max(right,left),Math.max(up,down));
        return gold;
    }
}