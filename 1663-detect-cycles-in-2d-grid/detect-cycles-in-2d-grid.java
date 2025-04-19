class Solution {
    int[][] dirn = {{0,1},{1,0},{0,-1},{-1,0}};
    int r,c;
    boolean[][] visited;
    public boolean containsCycle(char[][] grid) {
        r = grid.length; c = grid[0].length;
        visited = new boolean[r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(!visited[i][j] && dfs(new int[]{i,j},new int[]{-1,-1},grid[i][j],grid)){
                    // System.out.println(i + " "+ j);
                    return true;
                }
            }
        }

        return false;
    }


    public boolean dfs(int[] curr, int[] parent,char val, char[][] grid){
        int i = curr[0], j = curr[1];

        visited[i][j] = true;

        for(int[] dir : dirn){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x == parent[0] && y == parent[1]) continue;

            if(x>=0 && y>=0 && x<r && y<c && grid[x][y] == val){
                if(visited[x][y]){
                    return true;
                }else if(dfs(new int[]{x,y}, new int[]{i,j},val,grid)) {
                    return true;
                }
            }
        }

        return false;
    }

    
}