class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int x0, int y0) {
        int[][] output = new int[rows * cols][];
        output[0] = new int[] {x0, y0};
        int index = 1;

        
        
        for (int dist = 1; index < rows*cols ; dist++) {
            int x = x0 - dist;
            int y = y0;
            // top se left
            for (int i= 0; i<dist ; i++) {
                if (x >= 0 &&x < rows &&y >= 0 && y < cols) {
                    output[index++] = new int[] {x, y};
                }
                x++;y--;
            }

            // left se bottom
            for (int i= 0; i<dist ; i++) {
                if (x >= 0 &&x < rows &&y >= 0 && y < cols) {
                    output[index++] = new int[] {x, y};
                }
                x++;y++;
            }
            // bottom se right
            for (int i= 0; i<dist ; i++) {
                if (x >= 0 &&x < rows &&y >= 0 && y < cols) {
                    output[index++] = new int[] {x, y};
                }
                x--;y++;
            }

            // right se top
            for (int i= 0; i<dist ; i++) {
                if (x >= 0 &&x < rows &&y >= 0 && y < cols) {
                    output[index++] = new int[] {x, y};
                }
                x--;y--;
            }

        }
        return output;
    }
}
