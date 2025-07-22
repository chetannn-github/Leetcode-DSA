class Solution {
    int[][] dirns = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;
        int[][] distance = new int[m][n];
        for(int i=0; i<m; i++) {
            Arrays.fill(distance[i],Integer.MAX_VALUE);
        }

        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b)->(a.wt - b.wt));
        pq.add(new Triplet(0,0,0));
        distance[0][0] = 0;

        while(!pq.isEmpty()) {
            Triplet curr = pq.remove();
            int x = curr.x, y = curr.y , wt = curr.wt;

            for(int[] dirn : dirns) {
                int nx = x + dirn[0], ny = y + dirn[1];

                boolean isNonOutOfBound = (nx >= 0 && nx < m && ny >= 0 && ny < n);

                if(isNonOutOfBound) {
                   
                    if(wt < moveTime[nx][ny] && distance[nx][ny] > moveTime[nx][ny] + 1) { 
                       
                        pq.add(new Triplet(nx,ny,moveTime[nx][ny] + 1));
                        distance[nx][ny] = moveTime[nx][ny] + 1;
                    }else if(wt >= moveTime[nx][ny] && distance[nx][ny] > wt+1) {
                        pq.add(new Triplet(nx,ny,wt+1));
                        distance[nx][ny] = wt+1;
                    }
                }
            }
        }

        return distance[m-1][n-1];


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


