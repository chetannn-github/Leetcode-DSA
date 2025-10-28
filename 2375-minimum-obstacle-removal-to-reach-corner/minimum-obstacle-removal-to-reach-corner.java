class Solution {
    int[][] dirns = {{0,1}, {1,0},{0,-1}, {-1,0}};
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b)->(a.wt - b.wt));
        int[][] dist = new int[m][n];

        pq.add(new Triplet(0,0,0));
        
        for(int i=0; i<m; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        while(!pq.isEmpty()) {
            Triplet curr = pq.remove();
            int x = curr.x, y = curr.y, wt = curr.wt;

            if(x==m-1 && y==n-1) return dist[m-1][n-1];

            for(int[] dirn : dirns) {
                int nx = x + dirn[0], ny = y + dirn[1];
                boolean isOutOfBound = (nx<0 || ny<0 || nx>=m || ny>=n);

                if(isOutOfBound) continue;

                int nextWt = wt + grid[nx][ny];

                if(dist[nx][ny] > nextWt) {
                    dist[nx][ny] = nextWt;
                    pq.add(new Triplet(nx,ny,dist[nx][ny]));
                }

            }
        }

        return -1;
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