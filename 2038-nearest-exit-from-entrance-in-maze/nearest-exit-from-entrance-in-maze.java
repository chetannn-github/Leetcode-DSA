class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dirns ={{-1,0},{1,0}, {0,1}, {0,-1}};
        int rows = maze.length, cols = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int steps = -1;

        queue.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        
        while(!queue.isEmpty()) {
            int n = queue.size();

            while(n-->0) {
                int curr[] = queue.remove();
                int x = curr[0] , y = curr[1];
                boolean isExit = (
                    x == 0 || x == rows-1 || 
                    y == 0 || y == cols-1) &&
                    !(x == entrance[0] && y == entrance[1]
                );
                
                if(isExit) return steps+1;

                for(int[] dirn : dirns) {
                    int nx = x + dirn[0];
                    int ny = y + dirn[1];

                    boolean isValidStep = (nx >=0 && nx < rows && 
                        ny >=0 && ny < cols && 
                        maze[nx][ny] == '.'
                    );

                    if(isValidStep) {
                        queue.add(new int[]{nx,ny});
                        maze[nx][ny] = '+';
                    }
                }
            }
            steps++;
        }

        return -1;

    }
}