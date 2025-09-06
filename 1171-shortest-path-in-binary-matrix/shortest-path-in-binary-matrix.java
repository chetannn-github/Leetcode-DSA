// class Solution {
//     public int shortestPathBinaryMatrix(int[][] grid) {
//         int r = grid.length , c = grid[0].length;
//         int[][] dirn = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};

//         Queue<int[]> queue = new LinkedList<>();
//         if(grid[0][0] != 1){
//             grid[0][0] = 1;
//             queue.add(new int[]{0,0});
//         }

        
//         int level = 1;
//         while(!queue.isEmpty()){
//             int size = queue.size();

//             while(size-->0){
//                 int[] curr = queue.remove();
//                 if(curr[0] == r-1 && curr[1] == c-1){
//                     return level;
//                 }
//                 for(int[] dir : dirn){
//                     int x = curr[0] + dir[0];
//                     int y = curr[1] + dir[1];

//                     if(x>=0 && x<r && y >=0  && y<c && grid[x][y] != 1){
//                         queue.add(new int[]{x,y});
//                         grid[x][y] = 1;
//                     }
//                 }
//             }
//             level++;
//         }

//         return -1;
        
//     }
// }


class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int r = grid.length , c = grid[0].length;
        int[][] dirn = {{0,1},{0,-1}, {1,0},{-1,0}, {1,1},{1,-1}, {-1,1},{-1,-1}};
        int[][] dist = new int[r][c];

        for(int[] row : dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        
        if(grid[0][0] != 1){
            grid[0][0] = 1;
            dist[0][0] = 0;
            pq.add(new int[]{0,0,0}); // wt, x, y
        }

        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            int wt = curr[0];

            if(dist[curr[1]][curr[2]] < wt ) continue;
            
            for(int[] dir : dirn){
                int x = curr[1] + dir[0];
                int y = curr[2] + dir[1];

                if(x>=0 && x<r && y >=0  && y<c && grid[x][y] != 1 && dist[x][y] > wt+1){
                    pq.add(new int[]{wt+1,x,y});
                    grid[x][y] = 1;
                    dist[x][y] = wt+1;
                }
            }
            
        }

        return dist[r-1][c-1] == Integer.MAX_VALUE ? -1 : dist[r-1][c-1] +1;
        
    }
}