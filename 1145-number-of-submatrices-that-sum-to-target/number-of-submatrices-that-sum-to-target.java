class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        PrefixSumMatrix prefixSum = new PrefixSumMatrix(matrix);
        int rows = matrix.length;
        int cols = matrix[0].length;
        int result = 0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                for(int k=i; k<rows; k++) {
                    for(int l=j; l<cols; l++) {
                        result += prefixSum.query(i,j,k,l) == target ? 1 : 0;
                    }
                }
            }
        }


        return result;
    }
}

public class PrefixSumMatrix {
    int rows,cols;
    int[][] prefix;

    PrefixSumMatrix(int [][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        this.prefix = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                prefix[i][j] = matrix[i][j];
                if(i > 0) prefix[i][j] += prefix[i - 1][j];
                if(j > 0) prefix[i][j] += prefix[i][j - 1];
                if(i > 0 && j > 0) prefix[i][j] -= prefix[i - 1][j - 1];
            }
        }
    }
    public int query(int r1, int c1, int r2, int c2) {
        int result = prefix[r2][c2];
        if(r1 > 0) result -= prefix[r1 - 1][c2];
        if(c1 > 0) result -= prefix[r2][c1 - 1];
        if(r1 > 0 && c1 > 0) result += prefix[r1 - 1][c1 - 1];
        return result;
    }
}
