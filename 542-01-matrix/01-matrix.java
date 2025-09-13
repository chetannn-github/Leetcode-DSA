class Solution {
    int rows, cols;
    private static int[][] dirns = {{-1,0},{1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        int[][] result = new int[rows][cols];

        Queue<Pair> queue = new LinkedList<>();

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 0) {
                    queue.add(new Pair(i,j));
                    grid[i][j] = -1;
                }
            }
        }

        int distance = 1;
        while(!queue.isEmpty()) {
            int currSize = queue.size();

            while(currSize-->0) {
                Pair curr = queue.remove();

                for(int[] dirn : dirns) {
                    int nx = dirn[0] + curr.x;
                    int ny = dirn[1] + curr.y;

                    if(nx >=0  && ny >=0 && nx < rows && ny < cols) {
                        if(grid[nx][ny] == 0) {
                            grid[nx][ny] = -1;
                            queue.add(new Pair(nx,ny));
                        }else if(grid[nx][ny] == 1) {
                            queue.add(new Pair(nx,ny));
                            grid[nx][ny] = -1;
                            result[nx][ny] = distance;
                        }
                    }
                }
            }

            distance++;
        }
        return result;
    }
}




class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }  
}
