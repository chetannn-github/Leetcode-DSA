class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int max[] = new int[matrix[0].length];
        for(int[] row : matrix){
            for(int j=0; j<row.length; j++){
                max[j] = Math.max(max[j], row[j]);
            }
        }

        int ans[][] = new int[matrix.length][matrix[0].length];

        int r = 0;
        for(int[] row : matrix){
            for(int j=0; j<row.length; j++){
                if(row[j]==-1){
                    row[j] = max[j];
                }
            }

            ans[r] = row;
            r++;

        }
        return ans;
    }
}