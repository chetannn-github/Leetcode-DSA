class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length, c = heights[0].length;
        int[][] dist = new int[r][c];
        int[][] dirn = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int[] row : dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        pq.add(new int[]{0,0,0}); // effort,i,j
        dist[0][0] = 0;

        
        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            int effortTillNow = curr[0];

            if(curr[1] == r-1 && curr[2] == c-1) return dist[r-1][c-1];

            for(int[] dir : dirn){
                int x = curr[1] + dir[0];
                int y = curr[2] + dir[1];

                if(x>=0 && y>=0 && y<c && x < r){
                   int effort = Math.max(Math.abs(heights[x][y] - heights[curr[1]][curr[2]]), effortTillNow);

                    if(effort < dist[x][y]){
                        dist[x][y] =  effort;
                        pq.add(new int[]{effort,x,y});               
                    } 
                }

                
            }
        }

        return dist[r-1][c-1];
    }
}


