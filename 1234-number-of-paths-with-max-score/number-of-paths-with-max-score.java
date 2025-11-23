class Solution {
    int[][] dirns = {{0,1},{1,0},{1,1}};
    int n;
    Pair[][] dp;
    int MOD = 1_000_000_007;

    public int[] pathsWithMaxScore(List<String> board) {
        this.n = board.size();
        this.dp = new Pair[n][n];
        Pair res = solve(board,0,0);
        return new int[] {res.cost, res.paths};
    }


    private Pair solve(List<String> board, int x, int y) {
        if(x == n-1 && y == n-1) return new Pair(0,1);
        if(dp[x][y] != null) return dp[x][y];

        int maxCost = 0, totalPaths = 0;

        int currCost = (x==0 && y == 0) ? 0 : (int) board.get(x).charAt(y) - '0';

        for(int[] dirn : dirns) {
            int nx = x + dirn[0], ny = y + dirn[1];
            if(nx >= n || ny >= n || board.get(nx).charAt(ny) == 'X') continue;

            Pair result = solve(board,nx,ny);
            int cost = result.cost, paths = result.paths;
            
            if(cost + currCost > maxCost) {
                maxCost = currCost + cost;
                totalPaths = paths;
            } else if(cost + currCost == maxCost) {
                totalPaths = (totalPaths + paths) % MOD;
            }
        }

        maxCost = totalPaths == 0 ? 0 : maxCost;
        dp[x][y] = new Pair(maxCost,totalPaths);
        return dp[x][y];
    }
}


class Pair {
    int cost, paths;
    Pair(int cost, int paths) {
        this.cost = cost;
        this.paths = paths;
    }
}
