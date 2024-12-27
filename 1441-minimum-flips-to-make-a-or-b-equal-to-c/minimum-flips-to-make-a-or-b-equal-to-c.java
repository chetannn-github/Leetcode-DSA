class Solution {
    public int minFlips(int a, int b, int c) {
        int d = (a|b) ^c;
        int count = 0;

        while(d!=0){
            boolean lastBit = ((d&1)==1);
            if(lastBit){
                if((a&1) + (b&1) ==2){
                    count +=2;
                }else {
                    count++;
                }
            }

            b >>=1;
            a >>=1;
            d >>=1;
        }
        return count; 
    }
}