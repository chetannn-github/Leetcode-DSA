class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        int myCoins = 0;
        Arrays.sort(piles);

    
        int me = n-2;
        int reps = n/3;

        while(reps-->0){
            myCoins += piles[me];
            me -=2;
        }

        return myCoins;
    }
}