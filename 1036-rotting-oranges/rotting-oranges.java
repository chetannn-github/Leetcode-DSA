class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
       
        int freshCount = 0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                int val = grid[i][j];
                if(val == 2) {
                    queue.add(new int[]{i,j});
                    grid[i][j] = 0;
                }else if(val == 1) {
                    freshCount++;
                }
            }
        }
        
        int[][] dirns = {{-1,0},{1,0},{0,1},{0,-1}};
        int time = 0;
        while(!queue.isEmpty() && freshCount > 0) {
            int n = queue.size();

            while(n-->0) {
                int[] cell = queue.remove();
                int x = cell[0], y = cell[1];

                for(int[] dirn : dirns) {
                    int nx = x + dirn[0];
                    int ny = y + dirn[1];

                    if(nx >= 0 && ny >= 0 && nx < rows && ny < cols) {
                        if(grid[nx][ny] == 1) {
                            freshCount--;
                            queue.add(new int[]{nx,ny});
                            grid[nx][ny] = 0;
                        }
                    }
                }
            }
            time++;
        }
        
        return freshCount == 0 ? time : -1;
    }
}