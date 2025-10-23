class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dirns = {{0,1, 1}, {1,0,3}, {0,-1,2}, {-1,0,4}};
        int[][] dist = new int[m][n];

        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b)-> (a.wt - b.wt));
        
        for(int i=0; i<m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        pq.add(new Triplet(0,0,dist[0][0]));

        while(!pq.isEmpty()) {
            Triplet curr = pq.remove();
            int x = curr.x, y = curr.y, wt = curr.wt;

            if(dist[x][y] < wt) continue;

            for(int[] dirn : dirns) {
                int nx = x + dirn[0];
                int ny = y + dirn[1];

                if(isOutOfBound(nx,ny,m,n)) continue;

                int nextWt = dist[x][y] + (grid[x][y] == dirn[2] ? 0 : 1);

                if(dist[nx][ny] > nextWt) {
                    dist[nx][ny] = nextWt;
                    pq.add(new Triplet(nx, ny, dist[nx][ny]));
                }
            }
        }

        return dist[m-1][n-1];
    }


    private boolean isOutOfBound(int x, int y, int m, int n) {
        return x < 0 || y < 0 || x >= m || y >= n;
    }
}


class Triplet {
    int x, y, wt;
    Triplet(int x, int y, int wt) {
        this.x = x;
        this.y = y;
        this.wt = wt;
    }
}