class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
       

        int i=0;
        int freshCount = 0;
        for(int[] row : grid){
            int j=0;
            for(int val : row){
                
                if(val == 2){
                    queue.add(new int[]{i,j});
                    grid[i][j] = 0;
                }else if(val == 1){
                    freshCount++;
                }
                j++;
            }
            i++;
        }
        
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        int time = 0;
        while(!queue.isEmpty()){
            int n = queue.size();

            while(n-->0){
                int[] cell = queue.remove();
                int x = cell[0]; int y = cell[1];

                for(int[] dir : dirs){
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if(nx>=0 && ny >=0 && nx < r && ny < c){
                        if(grid[nx][ny] == 1){
                            freshCount--;
                            queue.add(new int[]{nx,ny});
                            grid[nx][ny] = 0;
                        }
                    }
                }
            }

            if(!queue.isEmpty()) time++;
        }
        
        return freshCount == 0 ? time : -1;
    }
}