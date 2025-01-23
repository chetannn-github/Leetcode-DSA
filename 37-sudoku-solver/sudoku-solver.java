class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board){


        for(int i=0; i<9;i++){
            for(int j=0; j<9; j++){

                if(board[i][j] == '.'){

                    for(char p='1';p<= '9'; p++){

                        if((isPossible(board,i,j,p))){
                            board[i][j] =  p;
                            if(solve(board)){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                        



                    }
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isPossible(char[][] board, int row,int col , char num){
        for(int i=0; i<9; i++){
            if(board[i][col] == num){
                return false;
            }
            if(board[row][i] == num){
                return false;
            }
            if(board[3*(row/3) + i%3][3* (col/3) + i/3] == num){
                return false;
            }
        }

        return true;
    }

}