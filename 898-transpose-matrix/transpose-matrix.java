class Solution {
    public int[][] transpose(int[][] matrix) {
         int length = matrix.length;
         if(length == matrix[0].length){
            for(int i=0; i<length; i++){
            for(int j=i+1; j<length;j++){
                // swap
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
                matrix[j][i] = matrix[i][j] ^ matrix[j][i];
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
            }
            }
            return matrix;
         }

         int[][] ans = new int[matrix[0].length][length];
         for(int i=0;i<ans.length; i++){
            int[] temp  = new int[length];
            for(int j=0; j<length; j++){
                temp[j] = matrix[j][i]; 
            }
            ans[i] = temp;
         }
        return ans;

    }
}