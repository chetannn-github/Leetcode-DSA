class Solution {
    public int[][] construct2DArray(int[] og, int m, int n) {
        if(m*n != og.length){
            return new int[][]{};
        }
        int [][] ans = new int[m][n];
        int count = 0;
        for(int i=0; i<m; i++){
            int[] row = new int[n];

            for(int j=0; j<n; j++){
                row[j] = og[count];
                count++;
            }
            ans[i] = row;
        }
        return ans;

    }
}