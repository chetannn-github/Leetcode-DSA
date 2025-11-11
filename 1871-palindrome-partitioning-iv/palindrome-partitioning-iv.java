class Solution {
    int[][] palindromeCache;
    int n;
    public boolean checkPartitioning(String s) {
        n = s.length();
        palindromeCache = new int[n][n];

        for(int[] row : palindromeCache) {
            Arrays.fill(row,-1);
        }

        return solve(s,0,0, 0);
    }

    private boolean solve(String s, int start,int curr, int cuts) {
        if(curr >= n) {
            return cuts == 2 && isPalindrome(s, start, curr-1);
        }
        
        if(cuts == 2) {
            return isPalindrome(s, start, n-1);
        }
        boolean result = solve(s, start, curr+1, cuts);
        if(curr < n-1 && cuts < 2 && isPalindrome(s,start, curr)) {
            result = result || solve(s,curr+1, curr+1, cuts+1);
        }
        return result;
    }
    
    private boolean isPalindrome(String s, int start,int end) {
        if(start >= end) return true;
        if(palindromeCache[start][end] != -1 ) return palindromeCache[start][end] == 1;

        boolean result = s.charAt(start) == s.charAt(end) && isPalindrome(s,start+1, end-1);
        palindromeCache[start][end] =  result ? 1 : 0;
        return result;
    }
}