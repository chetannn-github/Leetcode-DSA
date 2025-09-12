class Solution {
    int rows,cols;
    private static int[][] dirns = {{-1,0},{1,0},{0,1},{0,-1}};
    public int closedIsland(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        int totalClosedIslands = 0;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 0) {
                    totalClosedIslands += dfs(new Pair(i,j),grid) ? 1 : 0; 
                }
            }
        }
        
        
        return totalClosedIslands;
    }


    public boolean dfs(Pair curr, int[][] grid) {
        int x = curr.x, y = curr.y;
        boolean ans = true;
        if(isBoundary(x,y)) ans = false;;
        grid[x][y] = 1;

        for(int[] dirn : dirns) {
            int nx = x + dirn[0];
            int ny = y + dirn[1];

            if(nx >= 0 && ny >= 0 && nx < rows && ny < cols) {
                if(grid[nx][ny] == 0) {
                    if(!dfs(new Pair(nx,ny),grid)) ans = false;
                }
            }
        }

        return ans;
        
    }

    public boolean isBoundary(int x, int y) {
        return (x==0 || y==0 || x== rows-1 || y == cols-1);
    }
}


class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}