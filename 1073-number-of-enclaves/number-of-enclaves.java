class Solution {
    int rows,cols;
    public int numEnclaves(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        int totalNonBoundaryOnes = 0; 
        Queue<Pair> queue = new LinkedList<>();
        int[][] dirns = {{-1,0},{1,0},{0,1},{0,-1}};

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1 && isBoundary(i,j)) {
                    queue.add(new Pair(i,j));
                    grid[i][j] = 0;
                }else if (grid[i][j] == 1) totalNonBoundaryOnes++;
            }
        }
        

        while(!queue.isEmpty()) {
            int currSize = queue.size();

            while(currSize-->0) {
                Pair curr = queue.remove();
                int x = curr.x;
                int y = curr.y;

                for(int[] dirn : dirns) {
                    int nx = x + dirn[0];
                    int ny = y + dirn[1];

                    if(nx >= 0 && ny >= 0 && nx < rows && ny < cols) {
                        if(grid[nx][ny] == 1) {
                            totalNonBoundaryOnes--;
                            queue.add(new Pair(nx,ny));
                            grid[nx][ny] = 0;
                        }
                    }
                }
            }
        }

        return totalNonBoundaryOnes;
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