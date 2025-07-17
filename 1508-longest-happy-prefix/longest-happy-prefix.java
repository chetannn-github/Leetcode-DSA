class Solution {
    public String longestPrefix(String s) {
        KMP kmp = new KMP();
        kmp.computePrefixFunction(s);
        int lastPSIdx = kmp.lastPSIdx;
        int lastLPSLength = kmp.lastLPSLength;

        int n = s.length();
        StringBuilder result = new StringBuilder();
        

        for(int i= lastPSIdx-lastLPSLength+1; i<lastPSIdx+1; i++) {
            result.append(s.charAt(i));
        }

        return result.toString();
    }
}



class KMP {
    int lastPSIdx = 0;
    int lastLPSLength = 0;
    public int[] computePrefixFunction(String s) {
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

            if(LPS[n-1] > lastLPSLength) {
                lastLPSLength = LPS[n-1];
                lastPSIdx = n-1;
            }
        }
        return LPS;
    }

    
    // public int KMPSearch(String text, String pattern) {
    //     String combined = pattern + "#" + text;
    //     int[] LPS = computePrefixFunction(combined);
    //     int n = pattern.length();
        
    //     int result = 0;
    //     for (int i = n + 1; i < LPS.length; i++) {
    //         if (LPS[i] == n) {
    //             result++;
    //         }
    //     }

    //     return result;
    // }
}
