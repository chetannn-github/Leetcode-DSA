class Solution {
    public int minTimeToReach(int[][] moveTime) {
        return dijkstra(moveTime);
    }


    public int dijkstra(int[][] arr) {
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
            if(x + 1 < rows) {
                int nbrCost = Math.max(cost,arr[x+1][y]) + 1;
                if (dist[x+1][y] > nbrCost) {
                    dist[x+1][y] = nbrCost;
                    pq.add(new Triplet(x+1,y,nbrCost));
                }
            }


            if(x - 1 >= 0) {
                int nbrCost = Math.max(cost,arr[x-1][y]) + 1;
                if (dist[x-1][y] > nbrCost) {
                    dist[x-1][y] = nbrCost;
                    pq.add(new Triplet(x-1,y,nbrCost));
                }
            }

            if(y+1 < cols) {
                int nbrCost = Math.max(cost,arr[x][y+1]) + 1;
                if (dist[x][y+1] > nbrCost) {
                    dist[x][y+1] = nbrCost;
                    pq.add(new Triplet(x,y+1,nbrCost));
                }
            }

            if(y-1 >=0) {
                int nbrCost = Math.max(cost,arr[x][y-1]) + 1;
                if (dist[x][y-1] > nbrCost) {
                    dist[x][y-1] = nbrCost;
                    pq.add(new Triplet(x,y-1,nbrCost));
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