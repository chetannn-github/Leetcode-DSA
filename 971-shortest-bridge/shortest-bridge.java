class Solution {
    private static int flag = 69;
    int n;Queue<Pair> queue;
    private static int[][] dirns = {{-1,0},{1,0},{0,1},{0,-1}};

    public int shortestBridge(int[][] grid) {
        boolean isMarkedOneIsland = false;
        n = grid.length;
        this.queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    markOneIsland(i,j, grid);
                    isMarkedOneIsland = true;
                    break; 
                }
            }
            if(isMarkedOneIsland) break;
        }

        int distance = 0;
       

        while(!queue.isEmpty()) {
            int currSize = queue.size();
            while(currSize-- > 0) {
                Pair curr = queue.remove();

                for(int[] dirn : dirns) {
                    int nx = dirn[0] + curr.x;
                    int ny = dirn[1] + curr.y;

                    if(nx >=0  && ny >=0 && nx < n && ny < n) {
                        if(grid[nx][ny] == 0) {
                            grid[nx][ny] = -1;
                            queue.add(new Pair(nx,ny));
                        }else if(grid[nx][ny] == 1) {
                            return distance;
                        }
                    }
                }
            }
            distance++;
        }
        return distance;

        
    }

    public void markOneIsland(int i, int j, int[][] grid) {
        grid[i][j] = flag;
        queue.add(new Pair(i,j));

        for(int[] dirn : dirns) {
            int nx = i + dirn[0];
            int ny = j + dirn[1];

            if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if(grid[nx][ny] == 1 ) {
                    markOneIsland(nx,ny,grid);
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
