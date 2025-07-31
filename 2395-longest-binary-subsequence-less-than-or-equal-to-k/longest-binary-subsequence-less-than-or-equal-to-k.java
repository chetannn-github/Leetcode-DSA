class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int result = 0;
        int currNum = 0;
        
        for(int i = n-1; i>=0; i--) {
            int ch = (int) (s.charAt(i) - '0');
            currNum += ch * (Math.pow(2,n-1-i));

            if(currNum <= k) {
                result++;
            } else {
                result +=  countPrevZeroes(i,s);
                return result;
            }
            
        }

        return result;
    }


    public int countPrevZeroes(int idx, String s) {
        int zeroes = 0;
        for(int i=0; i<idx; i++) {
            zeroes += 1 - (int) (s.charAt(i) - '0');
        }

        return zeroes;
    }
}