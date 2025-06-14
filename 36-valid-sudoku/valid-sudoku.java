class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hs = new HashSet<>();

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                char ch = board[i][j];
                if(ch =='.') continue;
                int boxX = i/3;
                int boxY = j/3; 
                String idx = "*"+ch+"*";
                boolean isInvalid = hs.contains(i+idx) || hs.contains(idx+j) || hs.contains("!"+idx+"!"+boxY+"$"+boxX);
                if(isInvalid) return false;
                
                hs.add(i+idx);
                hs.add(idx+j);
                hs.add("!"+idx+"!"+boxY+"$"+boxX);
            }
        }
        return true;
    }
}