class Solution {
    public int countSubmatrices(int[][] grid, int k) {
    if(grid[0][0]>k){return 0;}
    int ans = 1;
    for(int i=0; i<grid.length; i++){
        for(int j=1; j<grid[0].length; j++){
            grid[i][j] += grid[i][j-1];
            if(i==0 && grid[i][j]<=k){
                ans++;
            }
        }
    }
    for(int i=1; i<grid.length; i++){
        for(int j=0; j<grid[0].length; j++){
            grid[i][j] += grid[i-1][j];
            if(grid[i][j]<=k){
                ans++;
            }
        }
    }

    return ans;

    }
}