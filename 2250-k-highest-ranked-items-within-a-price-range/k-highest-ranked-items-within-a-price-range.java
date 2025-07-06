class Solution {
    int m , n;
    int[][] grid;
    int[] pricing;
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<List<Integer>> result = new ArrayList<>();
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        this.pricing = pricing;

        PriorityQueue<QuadTruple> pq = new PriorityQueue<>((a,b)->{
            if(a.distance != b.distance) return a.distance - b.distance;
            if(a.price != b.price) return a.price - b.price;
            if(a.x != b.x) return  a.x - b.x;
            return  a.y - b.y;
        });                               

        Queue<QuadTruple> queue = new LinkedList<>();
        

        if(grid[start[0]][start[1]] != 0) {
            queue.add(new QuadTruple(start[0], start[1], 0, grid[start[0]][start[1]]));
            grid[start[0]][start[1]] = 0;
        }

        while(!queue.isEmpty()) {
            int n = queue.size();

            while(n --> 0) {
                QuadTruple curr = queue.remove();
                int distance = curr.distance;
                int x = curr.x , y = curr.y;

                if(isValidPrice(curr)) {
                    pq.add(new QuadTruple(x,y,distance, curr.price));
                }


                if(isValidPath(x+1,y) ) {
                    queue.add(new QuadTruple(x+1,y,distance+1, grid[x+1][y]));
                    grid[x+1][y] = 0;
                }

                if(isValidPath(x-1,y)) {
                    queue.add(new QuadTruple(x-1,y,distance+1, grid[x-1][y]));
                    grid[x-1][y] = 0;
                }
                if(isValidPath(x,y+1)) {
                    queue.add(new QuadTruple(x,y+1,distance+1, grid[x][y+1]));
                    grid[x][y+1] = 0;
                }

                if(isValidPath(x,y-1)) {
                    queue.add(new QuadTruple(x,y-1,distance+1, grid[x][y-1]));
                    grid[x][y-1] = 0;
                }
                
            }
            if(pq.size() > k) break;
        }

        
        while (k-->0 && !pq.isEmpty()) {
            QuadTruple curr = pq.remove();
            result.add(List.of(curr.x, curr.y));
        }
        return result;
    }

    private boolean isValidPath( int x, int y) {
        return (x >= 0 && x < m && y>=0 && y<n && grid[x][y] != 0);
    }
    private boolean isValidPrice(QuadTruple curr) {
        return (curr.price >= pricing[0] && curr.price<= pricing[1]);
    }
}


class QuadTruple {
    int x , y , distance, price;
    QuadTruple(int x, int y, int distance, int price) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.price = price;
    }
}