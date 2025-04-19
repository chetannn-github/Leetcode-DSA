class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int r = grid.length , c = grid[0].length;
        int[][] dirn = {{0,1},{0,-1}, {1,0},{-1,0}, {1,1},{1,-1}, {-1,1},{-1,-1}};

        Queue<int[]> queue = new LinkedList<>();
        if(grid[0][0] != 1){
            grid[0][0] = 1;
            queue.add(new int[]{0,0});
        }

        
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();

            while(size-->0){
                int[] curr = queue.remove();
                if(curr[0] == r-1 && curr[1] == c-1){
                    return level;
                }
                for(int[] dir : dirn){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];

                    if(x>=0 && x<r && y >=0  && y<c && grid[x][y] != 1){
                        queue.add(new int[]{x,y});
                        grid[x][y] = 1;
                    }
                }
            }
            level++;
        }

        return -1;
        
    }
}