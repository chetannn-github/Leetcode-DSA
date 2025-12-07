// class Solution {
//     int[][] dirns = {{0,1}, {1,0}};
//     int rows,cols;
//     int[][] grid;
//     HashMap<String,Integer>[][] dp;
//     public int calculateMinimumHP(int[][] grid) {
//         this.rows = grid.length;
//         this.cols = grid[0].length;
//         this.grid = grid;
//         this.dp = new HashMap[rows][cols];

//         for(int i=0; i<rows; i++) {
//             for(int j=0; j<cols; j++) {
//                 dp[i][j] = new HashMap<>();
//             }
//         }

        
//         return 1 - solve(0,0,0,0);
//     }

//     private int solve(int x, int y, int minScore, int score) {
//         int nextScore = score + grid[x][y];
//         int nextMinScore = Math.min(minScore,nextScore);
        
//         if(x == rows-1 && y == cols-1) return nextMinScore;
//         String key = minScore + " " + score;
//         if(dp[x][y].containsKey(key)) {
//             return dp[x][y].get(key);
//         }

//         int result = Integer.MIN_VALUE;
//         for(int[] dirn : dirns) {
//             int nx = x+dirn[0], ny = y + dirn[1];
//             if(nx >= rows || ny >= cols) continue;
//             result = Math.max(result,solve(nx,ny,nextMinScore,nextScore));
//         }
//         dp[x][y].put(key,result);
//         return result;
//     }

// }

// class Solution {
//     int[][] dirns = {{0,1}, {1,0}};
//     public int calculateMinimumHP(int[][] grid) {
//         int rows = grid.length;
//         int cols = grid[0].length;
//         PriorityQueue<Quadruplet> pq = new PriorityQueue<>((a,b)->b.minScore - a.minScore);

//         pq.add(new Quadruplet(0,0,grid[0][0], grid[0][0]));

//         while(!pq.isEmpty()) {
//             Quadruplet curr = pq.remove();
//             int x = curr.x, y = curr.y , score = curr.score, minScore = curr.minScore;

//             if(x == rows-1 && y == cols-1) return Math.max(1,1 - minScore);
//             for(int[] dirn : dirns) {
//                 int nx = x+dirn[0], ny = y + dirn[1];
//                 if(nx >= rows || ny >= cols) continue;
//                 int nextScore = score + grid[nx][ny];
//                 int nextMinScore = Math.min(minScore,nextScore);    
//                 pq.add(new Quadruplet(nx,ny,nextScore,nextMinScore));
//             }
//         }

//         return 0;
//     }

// }

// class Quadruplet {
//     int x,y,minScore,score;
//     Quadruplet(int x, int y, int score, int minScore) {
//         this.x = x;
//         this.y = y;
//         this.score = score;
//         this.minScore = minScore;
//     }
// }

 class Solution {
    int[][] dirns = {{0,1}, {1,0}};
    int rows,cols;
    int[][] grid;
    Integer[][] dp;
    public int calculateMinimumHP(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.grid = grid;
        this.dp = new Integer[rows][cols];

        return solve(0,0);
    }

    private int solve(int x, int y) {
        if(x == rows-1 && y == cols-1) return Math.max(1,1 - grid[x][y]);
        if(dp[x][y] != null) return dp[x][y];
        

        int result = Integer.MAX_VALUE;
        for(int[] dirn : dirns) {
            int nx = x+dirn[0], ny = y + dirn[1];
            if(nx >= rows || ny >= cols) continue;
            int currRes = solve(nx,ny);
            result = Math.min(result,currRes);
        }
        return dp[x][y] = Math.max(1,result - grid[x][y]);
    }

}