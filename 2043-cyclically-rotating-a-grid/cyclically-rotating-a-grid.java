class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int top = 0, left = 0, right = grid[0].length-1, bottom = grid.length-1;

        while(top<bottom && left<right){
            int elements = 2* (bottom -top) + 2*(right - left);
            int rotations = k % elements;

            while(rotations>0){
                int temp = grid[top][left];

                for(int i = left; i<right; i++){
                    grid[top][i] = grid[top][i+1];
                }
                for(int j = top; j<bottom; j++){
                    grid[j][right] = grid[j+1][right];
                }
                for(int p = right ; p>left; p--){
                    grid[bottom][p] = grid[bottom][p-1];
                }
                for(int l = bottom ; l>top; l--){
                    grid[l][left] = grid[l-1][left];
                }

                grid[top+1][left]  = temp;
                rotations--;
            }
            top++;
            left++;
            right--;
            bottom--;
        }

        return grid;
    }
}