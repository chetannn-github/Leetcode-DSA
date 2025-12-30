class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int countMagical = 0;

        for(int i=0; i<rows-2; i++) {
            for(int j=0; j<cols-2; j++) {
                countMagical += isMagicalGrid(grid,i,j) ? 1 : 0;
            }
        }

        return countMagical;
    }


    private boolean isMagicalGrid(int[][] grid,int i, int j) {
        int diagonalOneSum = grid[i][j] + grid[i+2][j+2];
        int diagonalTwoSum = grid[i][j+2] + grid[i+2][j];
        if(diagonalOneSum != diagonalTwoSum) return false;

        int rowOneSum = grid[i][j] + grid[i][j+1] + grid[i][j+2];
        int rowTwoSum = grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2];
        int rowThreeSum = grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];
        if(rowOneSum != rowTwoSum && rowOneSum != rowThreeSum) return false;


        int colOneSum = grid[i][j] + grid[i+1][j] + grid[i+2][j];
        int colTwoSum = grid[i][j+1] + grid[i+1][j+1] + grid[i+2][j+1];
        int colThreeSum = grid[i][j+2] + grid[i+1][j+2] + grid[i+2][j+2];
        if(colOneSum != colTwoSum && colOneSum != colThreeSum) return false;
        
        HashSet<Integer> values = new HashSet<>();

        for(int p=0; p<3; p++) {
            for(int q=0; q<3; q++) {
                int currVal = grid[i+p][j+q];
                if(currVal > 0 && currVal < 10 && !values.contains(currVal)) {
                    values.add(currVal);
                }
            }
        }

        return values.size() == 9;
    }
}