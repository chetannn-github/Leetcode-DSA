// TIME LIMIT EXCEEED
// class Solution {
//     int[][] dirns = {{0,1}, {0,-1}, {1,0}, {-1,0}};
//     int n;
//     public int largestIsland(int[][] grid) {
//         n = grid.length; 
//         int maxIsland = 0;
//         for(int i=0; i<n; i++) {
//             for(int j=0; j<n; j++) {
//                 if(grid[i][j] == 0) {
//                     maxIsland = Math.max(maxIsland,dfs(grid, i, j, new boolean[n][n]));
//                 }
//             }
//         }

//         return maxIsland == 0 ? n*n : maxIsland;
//     }


//     public int dfs(int[][] grid, int x, int y, boolean[][] visited) {
//         int maxIsland = 1;
//         visited[x][y] = true;
        
//         for(int[] dirn : dirns) {
//             int nx = dirn[0] + x, ny = dirn[1] + y;
//             if(isOutOfBound(nx, ny, n) || visited[nx][ny] || grid[nx][ny] == 0) continue;
//             maxIsland += dfs(grid, nx, ny, visited);
//         }
//         return maxIsland;
//     }

//     private boolean isOutOfBound(int x, int y, int n) {
//         return x < 0 || y < 0 || x > n-1 || y > n-1;
//     }
// }

class Solution {
    int[][] dirns = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    int n; int islandID = 2;
    public int largestIsland(int[][] grid) {
        HashMap<Integer, Integer> map = new HashMap<>();
        n = grid.length;
        int maxIsland = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    int islandSize = dfs(grid, i, j);
                    maxIsland = Math.max(maxIsland,islandSize);
                    map.put(islandID, islandSize);
                    islandID++;
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) {
                    HashSet<Integer> islandIDs = new HashSet<>();
                    for(int[] dirn : dirns) {
                        int nx = dirn[0] + i, ny = dirn[1] + j;
                        if(isOutOfBound(nx, ny, n) || grid[nx][ny] == 0) continue;
                        islandIDs.add(grid[nx][ny]);
                    }
                    int islandSize = 1;
                    for(int id : islandIDs) {
                        islandSize += map.get(id);
                    }
                    maxIsland = Math.max(maxIsland,islandSize);
                }
            }
        }
        
        
        return maxIsland == 0 ? n*n : maxIsland;
    }


    public int dfs(int[][] grid, int x, int y) {
        int maxIsland = 1;
        grid[x][y] = islandID;
        
        for(int[] dirn : dirns) {
            int nx = dirn[0] + x, ny = dirn[1] + y;
            if(isOutOfBound(nx, ny, n) || grid[nx][ny] != 1) continue;
            maxIsland += dfs(grid, nx, ny);
        }
        return maxIsland;
    }

    private boolean isOutOfBound(int x, int y, int n) {
        return x < 0 || y < 0 || x > n-1 || y > n-1;
    }
}