class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length, c = heights[0].length;
        int[][] dist = new int[r][c];
        int[][] dirn = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int[] row : dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b)->(a.effort-b.effort));
        pq.add(new Triplet(0,0,0)); // effort,i,j
        dist[0][0] = 0;

        
        while(!pq.isEmpty()){
            Triplet curr = pq.remove();
            int x = curr.x, y = curr.y;
            int effortTillNow = curr.effort;

            if(curr.x == r-1 && curr.y == c-1) return dist[r-1][c-1];
            if(dist[x][y] > effortTillNow) continue; // kuki aaage badegaa yaa barabarr rhegaa
            // agrr kam hone ki possibility hoti tohh nhii krta me continue;
            
            for(int[] dir : dirn){
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx>=0 && ny>=0 && ny<c && nx < r){
                   int effort = Math.max(Math.abs(heights[nx][ny] - heights[x][y]), effortTillNow);

                    if(effort < dist[nx][ny]){
                        dist[nx][ny] =  effort;
                        pq.add(new Triplet(effort,nx,ny));               
                    } 
                }

                
            }
        }

        return dist[r-1][c-1];
    }


}


class Triplet {
    int effort, x,y;
    Triplet(int effort, int x, int y) {
        this.effort = effort;
        this.x = x;
        this.y = y;
    }
}

