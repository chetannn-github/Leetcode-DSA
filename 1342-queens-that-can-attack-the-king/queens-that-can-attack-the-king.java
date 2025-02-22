class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean queenIndices[][] = new boolean[8][8];

        for(int[] queen : queens){
            queenIndices[queen[0]][queen[1]] = true;
        }
        int kingX= king[0];
        int kingY = king[1];

        int dir[] = {-1,0,1};

        for(int x: dir){
            for(int y: dir){
                if(x==y && y==0) continue;
                int cordX= kingX +x;
                int cordY = kingY +y;

                while(cordX>=0 && cordX<=7 && cordY<=7 && cordY>=0){
                    if(queenIndices[cordX][cordY]){
                        List<Integer> oneAns = new ArrayList<>();
                        oneAns.add(cordX);
                        oneAns.add(cordY);
                        ans.add(oneAns);
                        break;
                    }

                    cordX +=x;
                    cordY +=y;
                }
            }
        }

        return ans;
    }
}