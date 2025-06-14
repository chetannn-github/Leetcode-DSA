class Solution {
    public boolean checkMove(char[][] board, int r, int c, char color) {
        int[] dir = {-1,0,1};
        
        for(int x : dir){
            for(int y : dir){
                if(x == 0 && x == y) continue;
                int count = 1;
                int cordX = r + x;
                int cordY = c + y;
                boolean last = false;

                while (cordX>=0 && cordX <8 && cordY>=0 && cordY<8) {
                    if(board[cordX][cordY] == color) {
                        count++;
                        last = true;
                        break;
                    }else if(board[cordX][cordY] == '.' ) {
                        count = 0;
                        break;
                    }else if(board[cordX][cordY]!=color) {
                       count++;
                    }
                    cordX += x;
                    cordY +=y;
                }
                if (last && count>=3) return true;
            }
        }
        return false;
    }
}