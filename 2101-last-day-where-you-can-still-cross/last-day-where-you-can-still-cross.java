class Solution {
    int[][] dirns = {{0,1}, {1,0}, {-1,0},{0,-1}};
    int[][] grid;
    int row,col;
    public int latestDayToCross(int row, int col, int[][] cells) {
        int n = cells.length;
        this.row = row;
        this.col = col;
        grid = new int[row][col];
        
        for(int i=0; i<n; i++) {
            int x = cells[i][0]-1, y = cells[i][1]-1;
            grid[x][y] = i + 1;
        }

        int start = 0, end = n - 1;
        int result = 0;

        while(start <= end) {
            int mid = start + ((end - start) >> 1);
            boolean canCross = false;

            for(int j=0; j<col; j++) {
                if(grid[0][j] > mid) {
                    canCross = canCross || dfs(0,j,mid,new boolean[row][col]);
                }
            }

            if(canCross) {
                result = mid;
                start = mid + 1;
            }else end = mid - 1;
            
        }
        return result;
    }

    private boolean dfs(int x,int y, int day, boolean[][] visited) {
        if(x == row-1 ) return true;
        visited[x][y] = true;

        boolean result = false;
        for(int[] dirn : dirns) {
            int nx = x + dirn[0], ny = y + dirn[1];
            if(isOutOfBound(nx,ny,row,col)) continue;

            if(grid[nx][ny] > day && !visited[nx][ny]) {
                if(dfs(nx,ny,day,visited)) return true;
            }
        }

        return result;
    }


    private boolean isOutOfBound(int x, int y,int rows, int cols) {
        return x<0 || y<0 || x>=rows || y>=cols;
    }
}


// class Solution {
//     int ROW, COL;
//     int[][] dirns = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
//     private boolean dfs(int[][] grid, int x, int y) {
//         if (x < 0 || x >= ROW || y < 0 || y >= COL || grid[x][y] == 1) {
//             return false;
//         }

//         if (x == ROW - 1)
//             return true;

//         grid[x][y] = 1;
//         for (int[] dirn : dirns) {
//             int nx = x + dirn[0];
//             int ny = y + dirn[1];

//             if(dfs(grid, new_i, new_j)) return true;
//         }

//         return false;
//     }

//     private boolean canCross(int[][] cells, int day) {
//         int[][] grid = new int[ROW][COL];

//         for (int i = 0; i <= day; ++i) {
//             int r = cells[i][0] - 1;
//             int c = cells[i][1] - 1;
//             grid[r][c] = 1;
//         }

//         for (int j = 0; j < COL; j++) {
//             if (grid[0][j] == 0 && dfs(grid, 0, j))
//                 return true;
//         }
//         return false;
//     }

//     public int latestDayToCross(int row, int col, int[][] cells) {
//         this.ROW = row;
//         this.COL = col;

//         int n = cells.length;
//         int l = 0, r = n - 1;
//         int lastDay = 0;

//         while (l <= r) {
//             int mid = l + (r - l) / 2;

//             if (canCross(cells, mid)) {
//                 lastDay = mid + 1;
//                 l = mid + 1;
//             } else {
//                 r = mid - 1;
//             }
//         }

//         return lastDay;
//     }
// }
