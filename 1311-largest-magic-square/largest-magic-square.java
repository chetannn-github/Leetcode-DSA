class Solution {
    int[][] prefixGrid, grid;
    int rows,cols;

    public int largestMagicSquare(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.grid = grid;
        int largestMagicSquare = 1;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                int maxSquare = Math.min(rows-i, cols-j);
                if(maxSquare <= 1) break;
                largestMagicSquare = Math.max(largestMagicSquare,getMaxMagicSquare(i,j,maxSquare));
                
            }
        }

        return largestMagicSquare;
    }

    private int getMaxMagicSquare(int x, int y, int maxPossible) {
        int maxMagicSquare = 1;

        for(int sq=2; sq<=maxPossible; sq++) {
            int maxRow = x + sq;
            int maxCol = y + sq;
            
            int d1 = 0;
            int d2 = 0;

            int[] colSum = new int[sq];
            int[] rowSum = new int[sq];

            for(int row=x; row<maxRow; row++) {
                int currRowSum = 0;
                for(int col=y; col<maxCol; col++) {
                    colSum[col-y] += grid[row][col];
                    currRowSum += grid[row][col];

                    if(row-x == col-y) d1 += grid[row][col];
                    if(row-x + col-y == sq-1) d2 += grid[row][col];

                }
                rowSum[row-x] = currRowSum;
            }
           
            if(d1 != d2) continue;
            int sum = d1;
            boolean isMagic = true;
            for(int j=0; j<sq && isMagic; j++) {
                if(colSum[j] != sum) isMagic = false;
                if(rowSum[j] != sum) isMagic = false;
            }
            if(isMagic) maxMagicSquare = sq;
        }

        return maxMagicSquare;
    }
}