// class Solution {
//     int[][] dirns = {{0,1}, {1,0}, {-1,0},{0,-1}};
//     int[][] grid;
//     int row,col;
//     public int latestDayToCross(int row, int col, int[][] cells) {
//         int n = cells.length;
//         this.row = row;
//         this.col = col;
//         grid = new int[row][col];
        
//         for(int i=0; i<n; i++) {
//             int x = cells[i][0] - 1, y = cells[i][1]-1;
//             grid[x][y] = i + 1;
//         }

//         int start = 0, end = n - 1;
//         int result = 0;

//         while(start <= end) {
//             int mid = start + ((end - start) >> 1);
            
//             if(canCross(mid)) {
//                 result = mid;
//                 start = mid + 1;
//             }else end = mid - 1;
            
//         }
//         return result;
//     }

//     public boolean canCross(int currDay) {
//         boolean result = false;
//         for(int j=0; j<col; j++) {
//             if(grid[0][j] > currDay) {
//                 if(dfs(0,j,currDay,new boolean[row][col])) return true;
//             }
//         }
//         return false;
//     }

//     private boolean dfs(int x,int y, int day, boolean[][] visited) {
//         if(x == row-1 ) return true;
//         visited[x][y] = true;

//         boolean result = false;
//         for(int[] dirn : dirns) {
//             int nx = x + dirn[0], ny = y + dirn[1];
//             if(isOutOfBound(nx,ny,row,col)) continue;

//             if(grid[nx][ny] > day && !visited[nx][ny]) {
//                 if(dfs(nx,ny,day,visited)) return true;
//             }
//         }

//         return result;
//     }


//     private boolean isOutOfBound(int x, int y,int rows, int cols) {
//         return x<0 || y<0 || x>=rows || y>=cols;
//     }
// }

class Solution {
    int[][] dirns = {{0,1}, {1,0}, {-1,0},{0,-1}};
    int row, col;

    public int latestDayToCross(int row, int col, int[][] cells) {
        this.row = row;
        this.col = col;
        int n = cells.length;

        int start = 0, end = n - 1;
        int result = 0;

        while (start <= end) {
            int mid = start + ((end - start) >> 1);

            if (canCross(mid, cells)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result + 1;
    }

    private boolean canCross(int currDay, int[][] cells) {
        int[][] grid = new int[row][col];

        for(int i=0; i<=currDay; i++) {
            int x = cells[i][0] - 1,y = cells[i][1] - 1;
            grid[x][y] = 1;
        }

        for(int j=0; j<col; j++) {
            if(grid[0][j] == 0 && dfs(0, j, grid)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int[][] grid) {
        if(x == row - 1) return true;

        grid[x][y] = 1;

        for (int[] dirn : dirns) {
            int nx = x + dirn[0];
            int ny = y + dirn[1];

            if(!isOutOfBound(nx, ny, row, col) && grid[nx][ny] == 0) {
                if (dfs(nx, ny, grid)) return true;
            }
        }
        return false;
    }

    private boolean isOutOfBound(int x, int y, int rows, int cols) {
        return x < 0 || y < 0 || x >= rows || y >= cols;
    }
}
