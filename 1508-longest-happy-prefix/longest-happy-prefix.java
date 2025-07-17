class Solution {
    public String longestPrefix(String s) {
        KMP kmp = new KMP();
        kmp.computePrefixFunction(s);
        int maxLPSIdx = kmp.maxLPSIdx;
        int maxLPSLength = kmp.maxLPSLength;

        int n = s.length();
        StringBuilder result = new StringBuilder();
        System.out.println(maxLPSLength);
        System.out.println(maxLPSIdx);

        for(int i= maxLPSIdx-maxLPSLength+1; i<maxLPSIdx+1; i++) {
            result.append(s.charAt(i));
        }

        return result.toString();
    }
}



class KMP {
    int maxLPSIdx = 0;
    int maxLPSLength = 0;
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

            if(LPS[n-1] > maxLPSLength) {
                maxLPSLength = LPS[n-1];
                maxLPSIdx = n-1;
            }
        }
        return LPS;
    }

    
    public int KMPSearch(String text, String pattern) {
        String combined = pattern + "#" + text;
        int[] LPS = computePrefixFunction(combined);
        int n = pattern.length();
        
        int result = 0;
        for (int i = n + 1; i < LPS.length; i++) {
            if (LPS[i] == n) {
                result++;
            }
        }

        return result;
    }
}
