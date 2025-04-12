class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int r = maze.length;
        int c = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int count = -1;
        int[][] dir ={{-1,0},{1,0}, {0,1}, {0,-1}};
        
        while(!queue.isEmpty()){
            int n = queue.size();

            while(n--> 0){
                int curr[] = queue.remove();
                int x = curr[0];
                int y = curr[1];
                
                if((x == 0 || x == r-1 || y == 0 || y == c-1) && !(x == entrance[0] && y == entrance[1]) ){
                    return count+1;
                }

                for(int i=0; i<4; i++){
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];

                    if(nx >=0 && nx < r && ny >=0 && ny < c && maze[nx][ny] == '.'){
                        queue.add(new int[]{nx,ny});
                        maze[nx][ny] = '+';
                    }
                }
            }
            count++;
        }

        return -1;

    }
}