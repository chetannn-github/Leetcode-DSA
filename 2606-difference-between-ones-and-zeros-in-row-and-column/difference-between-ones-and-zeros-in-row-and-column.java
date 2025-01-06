class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] colOnes = new int[cols];
        int[] rowOnes = new int[rows];

        for(int i=0; i<rows; i++){
            int ones = 0;
            for(int j=0; j<cols; j++){
                if(grid[i][j]==1){
                    colOnes[j]++;
                    ones++;
                }
            }
            rowOnes[i] = ones;
        }

        for(int i=0; i<rows; i++){
           for(int j=0; j<cols; j++){
               grid[i][j] = (2* rowOnes[i] + 2*colOnes[j] - (rows + cols));
            }
        }

        return grid;





        
    }
}