class Solution {
    public int strStr(String text, String pattern) {
        // return brute (haystack,needle);
        List<Integer> result =  KMPSearch(text, pattern);
        return result.size() > 0 ? result.get(0) : -1; 
    }

    public int brute(String haystack, String needle) {
        for(int i=0; i<haystack.length(); i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                int j=1;
                for(;i+j<haystack.length() && j<needle.length();j++){
                    if(haystack.charAt(i+j)!=needle.charAt(j)){
                        break;
                    }
                }
                if(j==needle.length()){
                    return i;
                }
            }
        }
        return -1;
    }


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
        }
        return LPS;
    }

    
    public List<Integer> KMPSearch(String text, String pattern) {
        String combined = pattern + "#" + text;
        int[] LPS = computePrefixFunction(combined);
        int n = pattern.length();
        List<Integer> result = new ArrayList<>();

        for (int i = n + 1; i < LPS.length; i++) {
            if (LPS[i] == n) {
                result.add(i - 2 * n);
            }
        }

        return result;
    }
}

