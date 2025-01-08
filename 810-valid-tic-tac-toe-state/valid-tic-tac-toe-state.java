class Solution {
    public boolean validTicTacToe(String[] board) {
        int countX = 0; 
        int countO = 0;
        for(String word : board){
            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);
                if(ch=='O'){countO++;}
                else if(ch=='X'){countX++;}

            }
        }

        if(countX<countO || Math.abs(countX - countO)>=2){
            return false;
        }

        // check if x win

        if(isXWinner(board)){
            if(countX==countO){
                return false;
            }
        }

    if(isOWinner(board)){
            if(countO!=countX){
                return false;
            }
        }

        return true;
    }


    public boolean isXWinner(String[] board){
        return (board[0].equals("XXX") || board[1].equals("XXX")|| board[2].equals("XXX") || (board[0].charAt(0)=='X' && board[1].charAt(1)=='X' && board[2].charAt(2)=='X') || (board[0].charAt(0)=='X' && board[1].charAt(0)=='X' && board[2].charAt(0)=='X') || (board[0].charAt(1)=='X' && board[1].charAt(1)=='X' && board[2].charAt(1)=='X') || (board[0].charAt(2)=='X' && board[1].charAt(2)=='X' && board[2].charAt(2)=='X')|| (board[0].charAt(2)=='X' && board[1].charAt(1)=='X' && board[2].charAt(0)=='X'));
    }
    public boolean isOWinner(String[] board){
        return (board[0].equals("OOO") || board[1].equals("OOO")|| board[2].equals("OOO") || (board[0].charAt(0)=='O' && board[1].charAt(1)=='O' && board[2].charAt(2)=='O') || (board[0].charAt(0)=='O' && board[1].charAt(0)=='O' && board[2].charAt(0)=='O') || (board[0].charAt(1)=='O' && board[1].charAt(1)=='O' && board[2].charAt(1)=='O') || (board[0].charAt(2)=='O' && board[1].charAt(2)=='O' && board[2].charAt(2)=='O')|| (board[0].charAt(2)=='O' && board[1].charAt(1)=='O' && board[2].charAt(0)=='O'));
    }
}