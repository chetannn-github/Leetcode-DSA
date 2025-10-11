class Solution {
    public int minTimeToReach(int[][] moveTime) {
        return dijkstra(moveTime);
    }


    public int dijkstra(int[][] arr) {
        int[][] dirns = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int rows = arr.length, cols = arr[0].length;
        int[][] dist = new int[rows][cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b)->(a.cost - b.cost));
        pq.add(new Triplet(0,0,0));
        dist[0][0] = 0;

        while(!pq.isEmpty()) {
            Triplet curr = pq.remove();
            int x = curr.x, y = curr.y, cost = curr.cost;
            if(dist[x][y] < cost) continue;

            for(int[] dirn : dirns) {
                int nx = x + dirn[0], ny = y + dirn[1];
                boolean isNonOutOfBound = (nx >= 0 && nx < rows && ny >= 0 && ny < cols);

                if(isNonOutOfBound) {
                    int nbrCost = Math.max(cost,arr[nx][ny]) + 1;

                    if (dist[nx][ny] > nbrCost) {
                    dist[nx][ny] = nbrCost;
                    pq.add(new Triplet(nx,ny,nbrCost));
                }
                }
            }
        }
        return dist[rows-1][cols-1];
    }
}


class Triplet {
    int x, y, cost;
    Triplet(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}