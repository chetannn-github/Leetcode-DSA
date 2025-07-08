class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
       

        int i=0;
        int freshCount = 0;
        for(int[] row : grid) {
            int j=0;
            for(int val : row) {
                
                if(val == 2) {
                    queue.add(new int[]{i,j});
                    grid[i][j] = 0;
                }else if(val == 1) {
                    freshCount++;
                }
                j++;
            }
            i++;
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

                    if(nx >= 0 && ny >= 0 && nx < r && ny < c) {
                        if(grid[nx][ny] == 1) {
                            freshCount--;
                            queue.add(new int[]{nx,ny});
                            grid[nx][ny] = 0;
                        }
                    }
                }
            }
            time++;
            if(freshCount == 0) return time;
            
        }
        
        return freshCount == 0 ? time : -1;
    }
}