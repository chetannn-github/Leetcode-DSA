import java.util.*;

class Solution {
    public int minimumTime(int[][] grid) {
        return dijkstra(grid);
    }

    public int dijkstra(int[][] grid) {
        if(grid[1][0] > 1 && grid[0][1] > 1) return -1;

        int[][] dirns = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> dist[a.x][a.y] - dist[b.x][b.y]);
        dist[0][0] = grid[0][0];
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int x = curr.x, y = curr.y;
            int time = dist[x][y];

            if (x == m-1 && y == n-1) return time;

            if (time > dist[x][y]) continue;

            for(int[] dirn : dirns) {
                int nx = x + dirn[0], ny = y + dirn[1];
                if(isOutOfBound(nx,ny, m ,n)) continue;

                int nextTime = time + 1;
                if (nextTime < grid[nx][ny]) {
                    int diff = grid[nx][ny] - nextTime;
                    nextTime = grid[nx][ny] + (diff % 2 == 0 ? 0 : 1);
                }

                if (nextTime < dist[nx][ny]) {
                    dist[nx][ny] = nextTime;
                    pq.add(new Pair(nx,ny));
                }
            }
        }

        return -1;
    }

    private boolean isOutOfBound(int x, int y, int m, int n) {
        return x < 0 || y < 0 || x >= m || y >= n;
    }
}

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
