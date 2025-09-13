class Solution {
    int rows, cols;
    boolean[][] visited;
    private static int[][] dirns = {{-1,0},{1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        this.rows = board.length;
        this.cols = board[0].length;
        this.visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(board[i][j] == 'O' && isBoundary(i,j) && !visited[i][j]) {
                    dfs(new Pair(i,j),board);
                }
            }
        }

        changeGrid(visited,board);
        return;
    }



    public void dfs(Pair curr, char[][] board) {
        int x = curr.x, y = curr.y;
        visited[x][y] = true;

        for(int[] dirn : dirns) {
            int nx = x + dirn[0];
            int ny = y + dirn[1];

            if(nx >= 0 && ny >= 0 && nx < rows && ny < cols) {
                if(board[nx][ny] == 'O' && !visited[nx][ny]) {
                    dfs(new Pair(nx,ny),board);
                }
            }
        }
    }

    public boolean isBoundary(int x, int y) {
        return (x==0 || y==0 || x== rows-1 || y == cols-1);
    }


    public void changeGrid(boolean[][] visited, char[][] board) {
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
        
    }
}


class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }  
}


// class Solution {
//     int rows, cols;
//     private static int[][] dirns = {{-1,0},{1,0},{0,1},{0,-1}};

//     public void solve(char[][] board) {
//         if (board == null || board.length == 0) return;
//         this.rows = board.length;
//         this.cols = board[0].length;

//         for (int i = 0; i < rows; i++) {
//             if (board[i][0] == 'O') dfs(i, 0, board);
//             if (board[i][cols - 1] == 'O') dfs(i, cols - 1, board);
//         }
//         for (int j = 0; j < cols; j++) {
//             if (board[0][j] == 'O') dfs(0, j, board);
//             if (board[rows - 1][j] == 'O') dfs(rows - 1, j, board);
//         }

//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 if (board[i][j] == 'O') board[i][j] = 'X';
//                 else if (board[i][j] == '$') board[i][j] = 'O';
//             }
//         }
//     }

//     private void dfs(int x, int y, char[][] board) {
//         if (x < 0 || y < 0 || x >= rows || y >= cols || board[x][y] != 'O') return;

//         board[x][y] = '$';
//         for (int[] dir : dirns) {
//             dfs(x + dir[0], y + dir[1], board);
//         }
//     }
// }
