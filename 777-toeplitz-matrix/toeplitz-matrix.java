class Solution {
    public boolean isToeplitzMatrix(int[][] mat) {
         int r = mat.length;
        int c = mat[0].length;

        for(int i=0; i<mat.length; i++){
            int row = i;
            int col = 0;
            int el = mat[i][0];
            while(row<r && col<c){
               if(mat[row][col]!= el){
                    return false;
                }
                row++;
                col++;
            }

            
        }
        for(int i=1; i<mat[0].length; i++){
            int row = 0;
            int col = i;
            int el = mat[0][i];
            while(row<r && col<c){
                if(mat[row][col]!= el){
                    return false;
                }
                row++;
                col++;
            }

           
        }

        return true;
    }
}