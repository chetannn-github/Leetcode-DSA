class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int max[] = new int[matrix[0].length];
        for(int[] row : matrix){
            for(int j=0; j<row.length; j++){
                max[j] = Math.max(max[j], row[j]);
            }
        }

        for(int[] row : matrix){
            for(int j=0; j<row.length; j++){
                row[j] = row[j]==-1 ? max[j] : row[j];
            }
        }
        return matrix;
    }
}