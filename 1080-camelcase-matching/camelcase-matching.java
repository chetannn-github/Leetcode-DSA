class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        int n = pattern.length();

        for(String q : queries) {
            ans.add(camelCaseMatching(q,pattern,n));
        }

        return ans;
    }

    public boolean camelCaseMatching (String q, String pattern, int patternLength) {
        int i = 0;
        int j = 0;

        int queryLength = q.length();

        if(patternLength > queryLength) return false;

        while(i<patternLength && j < queryLength) {
            char patternChar = pattern.charAt(i);
            char qChar = q.charAt(j);
            boolean bothUpper = (isUpperCase(patternChar) && isUpperCase(qChar)) ;
            boolean bothLower =  (!isUpperCase(patternChar) && !isUpperCase(qChar) );

            if (bothUpper) {
                if(patternChar == qChar) {
                    i++;
                    j++;
                }else {
                    return false;
                }
            }else if (bothLower) {
                if (patternChar == qChar) {
                    i++;
                    j++;
                }else {
                    j++;
                }
            } else if (isUpperCase(patternChar) && !isUpperCase(qChar)) {
                j++;
            }else {
                // pattern lower and query upper
                return false;
            }
        }

        while( j < queryLength && !isUpperCase(q.charAt(j))) { j++;}

        return i >= patternLength && j >= queryLength;
        
    }

    public boolean isUpperCase(char ch){
        return ch >= 'A' && ch <= 'Z';
    }
}