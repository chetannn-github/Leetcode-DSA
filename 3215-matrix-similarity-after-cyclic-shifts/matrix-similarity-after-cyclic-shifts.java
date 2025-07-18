class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int cols = mat[0].length;
        k %=cols;
        if(k==0){return true;}

        for(int i=0;i<mat.length; i++){
            for(int j=0; j<cols; j++){
                if(mat[i][j]!=mat[i][(j+k)%cols]){
                    return false;
                }
            }
        }

        return true;
    }
}