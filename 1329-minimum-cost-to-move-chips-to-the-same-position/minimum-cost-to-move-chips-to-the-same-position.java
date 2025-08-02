class Solution {
    public int minCostToMoveChips(int[] position) {
        int zeroes = 0, ones = 0;
        for(int i=0; i<position.length; i++) {
            if(position[i] % 2 == 0) zeroes++;
            else ones++;
        }
        return Math.min(ones , zeroes);
    }
}