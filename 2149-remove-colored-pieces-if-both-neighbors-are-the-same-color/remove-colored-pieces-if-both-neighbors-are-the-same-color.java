class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        int alice = 0;
        int bob = 0;

        for(int i=1; i<n-1; i++) {
            char curr = colors.charAt(i);
            char prev = colors.charAt(i-1);
            char next = colors.charAt(i+1);
            
            if(curr == 'A' && prev == curr && curr == next) {
                alice++;
            }else if(curr == 'B' && prev == curr && curr == next) {
                bob++;
            }
        }

        return alice > bob;
    }
}