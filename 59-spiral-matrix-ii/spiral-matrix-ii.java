class Solution {
    public int[][] generateMatrix(int n) {
        int top = 0, left = 0, right = n-1, bottom = n-1;
        int[][] grid = new int[n][n];
        int start = 1;

        while(top<=bottom && left<=right){
            
            for(int i = left; i<=right; i++){
                grid[top][i] = start++;
            }
            top++;

            for(int j = top; j<=bottom; j++){
                grid[j][right]= start++ ;
            }
            right--;
            
            if(top<=bottom){
                for(int p = right ; p>=left; p--){
                    grid[bottom][p]= start++;
                }
                bottom--;
            }
            if(left<=right){
                for(int l = bottom ; l>=top; l--){
                    grid[l][left]= start++;
                }
                left++;
            }
            
        }
        
        return grid;
    }
}