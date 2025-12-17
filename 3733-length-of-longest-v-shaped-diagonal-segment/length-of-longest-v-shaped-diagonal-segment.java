class Solution {
    int rows,cols;
    int[][] grid;
    int[][] allDirns = {{1,1},{1,-1},{-1,-1},{-1,1}};
    Integer[][][][][] dp;
    public int lenOfVDiagonal(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.grid = grid;
        this.dp = new Integer[rows][cols][4][2][3];
        int maxLength = 0;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1) {
                    for(int dirn=0; dirn<4; dirn++) {
                        maxLength = Math.max(maxLength,1 + solve(i,j,dirn,0,2));
                    }
                    
                }
            }
        }

        return maxLength;
    }

    private int solve(int x, int y, int currDirn, int turnTaken, int expect) {
        if(dp[x][y][currDirn][turnTaken][expect] != null) return dp[x][y][currDirn][turnTaken][expect];
        int[] dirns = allDirns[currDirn];
        int result = 0;

        int nx = x + dirns[0], ny = y + dirns[1];
        if(nx >= 0 && ny >= 0 && nx < rows && ny < cols && grid[nx][ny] == expect) {
            result = Math.max(result,1+ solve(nx,ny,currDirn,turnTaken,2-expect));
        }
        

        if(turnTaken == 0) {

            int changedDirn = (currDirn + 1) % 4; 
            
            int[] dirn = allDirns[changedDirn];
            nx = x + dirn[0];
            ny = y + dirn[1];
            
            if(nx >= 0 && ny >= 0 && nx < rows && ny < cols && grid[nx][ny] == expect) {
                result = Math.max(result, 1 + solve(nx, ny, changedDirn, 1, 2 - expect));
            }
        }

        return dp[x][y][currDirn][turnTaken][expect] = result;
    }
}