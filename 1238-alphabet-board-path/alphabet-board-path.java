class Solution {
    public String alphabetBoardPath(String target) {

        // bus catch yahaa yhhh hh down sbse baadme krnaa nhii z ki wjh se dikkkt ho skti hh
        String[] board = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        HashMap<Character, int[]> hm = new HashMap<>();

        for (int row = 0; row < board.length; row++) {
            String line = board[row];
            for (int col = 0; col < line.length(); col++) {
                char c = line.charAt(col);
                hm.put(c, new int[]{row, col});
            }
        }
        int x = 0, y=0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<target.length(); i++){
            char ch = target.charAt(i);
            int reqX= hm.get(ch)[0];
            int reqY = hm.get(ch)[1];


            while(reqX != x  || reqY != y){
                if(reqY<y){
                    sb.append("L");
                    y--;
                    
                }else if(reqX<x){
                    sb.append("U");
                    x--;
                    
                }else if(reqX > x){
                    sb.append("D");
                    x++;
                    
                }else if(reqY>y){
                    sb.append("R");
                    y++;
                    
                }
            } 
            sb.append("!");
        }

        return sb.toString();
    }
}