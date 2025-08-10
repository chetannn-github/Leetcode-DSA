class Solution {
    public int minimumSwap(String s1, String s2) {
        int x = 0, y = 0;
        int n = s1.length();

        for(int i=0; i<n; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if(ch1 == 'x') x++;
            else y++;

            if(ch2 == 'x') x++;
            else y++;
        }
        boolean isXDivByTwo = (x%2) == 0;
        boolean isYDivByTwo = (y%2) == 0;
        if(!isXDivByTwo || !isYDivByTwo) return -1;

        int XY = 0;
        int YX = 0;

        for(int i=0; i<n; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(ch1 == ch2) continue;

            if(ch1 == 'x') XY++;
            else YX++;
        }
        return (XY + 1)/2 + (YX + 1)/2 ;
    }
}