class Solution {
    public String shortestPalindrome(String s) {
        KMP kmp = new KMP();
        int n = s.length();

        StringBuilder sb = new StringBuilder(s);
        int[] lps = kmp.computeLPS(s + "#" + sb.reverse().toString());
        int lengthOfLargestPrefixPalindrome = lps[2*n];
        int charsToBeAdded = n - lengthOfLargestPrefixPalindrome;
        System.out.println(charsToBeAdded);

        StringBuilder result = new StringBuilder();
        for(int i= n - charsToBeAdded; i <= n-1  ; i++){
            result.append(s.charAt(i));
        }


        return result.reverse().toString() + s;
    }
}


class KMP {
    public int[] computeLPS(String s) {
        int n = s.length();
        int[] LPS = new int[n];
        for (int i = 1; i < n; i++) {
            int j = LPS[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = LPS[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            LPS[i] = j;
        }
        return LPS;
    }
}

