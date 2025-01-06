class Solution {
    public char[][] rotateTheBox(char[][] mat) {
        int length = mat.length;
        char[][] ans = new char[mat[0].length][length];

        for(int i=0;i<mat.length; i++){
            int lastDot = -1;
            for(int j=mat[0].length-1; j>=0; j--){
                if(lastDot==-1&&mat[i][j]=='.' ) {
                   lastDot = j;
                }else if(mat[i][j]=='*' ) {
                   lastDot = -1;
                }else if(lastDot!=-1 && mat[i][j]=='#') {
                    mat[i][j]='.' ;
                    mat[i][lastDot]='#';
                    lastDot--;
               }
            }
            
        }

        for(int i=0;i<ans.length; i++){
            char[] temp = new char[length];
            for(int j=0;j<length; j++){
                temp[length-1-j] = mat[j][i];
            }
            ans[i] = temp;
        }

        
        
        return ans;
        
    }
}