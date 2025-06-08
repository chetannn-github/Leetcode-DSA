class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        for(int[] row : mat) {
            int cumVal = 0;
            for(int j= n-1; j>=0; j--) {
                cumVal = row[j] == 0 ? 0 : cumVal + 1;
                row[j] = cumVal;
            }
        }

        int count = 0;
        for(int i=0; i<m ; i++) {
            for(int j=0; j<n; j++) {
                int min = mat[i][j];

                for(int p=i; p<m; p++) {
                    min = Math.min(mat[p][j], min);
                    if(min == 0) break;
                    count += min;
                }
            }
        }

        return count;
    }
}