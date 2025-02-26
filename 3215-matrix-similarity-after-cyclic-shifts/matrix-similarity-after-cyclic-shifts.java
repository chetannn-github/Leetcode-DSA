class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        
        k %=mat[0].length;
        if(k==0){return true;}

        for(int i=0;i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]!=mat[i][(j+mat[0].length)%k]){
                    return false;
                }
            }
        }

        return true;
    }
}