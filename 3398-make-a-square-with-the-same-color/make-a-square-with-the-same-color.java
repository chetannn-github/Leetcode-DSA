class Solution {
    public boolean canMakeSquare(char[][] grid) {
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                int count  = 1;

                if (grid[i][j]==grid[i][j+1]) count++;
                if (grid[i][j]==grid[i+1][j]) count++;
                if (grid[i][j]==grid[i+1][j+1]) count++;

                if (count==1 || count==3 || count==4) return true;
            }
        }
        return false;
    }
}