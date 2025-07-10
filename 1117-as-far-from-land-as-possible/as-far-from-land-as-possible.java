class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] dirns = {{-1,0},{1,0},{0,1},{0,-1}};
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<n*n; i++) {
            if(grid[i/n][i%n] == 1) {
                queue.add(i);
            }
        }
        if(queue.size() == n*n) return -1;
        int maxDistance = -1;
        while(!queue.isEmpty()) {
            int currSize = queue.size();

            while(currSize-->0) {
                int curr = queue.remove();
                int x = curr / n; 
                int y = curr % n;

                for(int[] dirn : dirns) {
                    int nx = x + dirn[0];
                    int ny = y + dirn[1];

                    if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if(grid[nx][ny] == 0) {
                            grid[nx][ny] = 1;
                            queue.add(nx*n + ny);
                        }
                    }
                }        
            
            }
            maxDistance++;
        }

        return maxDistance ;
    }
}