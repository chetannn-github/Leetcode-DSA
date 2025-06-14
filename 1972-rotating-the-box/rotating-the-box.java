class Solution {
    public char[][] rotateTheBox(char[][] mat) {
        // always remeberr apply all ops to row 
        int r = mat.length , c = mat[0].length;
        char[][] ans = new char[c][r];

        for(int i=0;i<r; i++){
            int lastHash = -1;
            for(int j=0; j < c; j++){
                if(lastHash==-1 && mat[i][j]=='#' ) {
                   lastHash = j;
                }else if(mat[i][j]=='*') {
                   lastHash = -1;
                }else if(lastHash!=-1 && mat[i][j]=='.') {
                    mat[i][j]='#' ;
                    mat[i][lastHash]='.';
                    lastHash++;
               }
            }
            
        }

        for(int i=0;i<ans.length; i++){
            char[] temp = new char[r];
            for(int j=0;j<r; j++){
                temp[r-1-j] = mat[j][i];
            }
            ans[i] = temp;
        }

        return ans;
        
    }
}