class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        KMP kmp = new KMP();
        StringBuilder patternString = new StringBuilder();
        for(int i=0; i<pattern.length; i++) {
            if(pattern[i] == -1) pattern[i] = 2;
            patternString.append(pattern[i]);
        }
        StringBuilder text = new StringBuilder();

        for(int i=1; i<nums.length; i++) {
            int curr = 0;
            if(nums[i] > nums[i-1] ) curr = 1;
            else if (nums[i] < nums[i-1] ) curr = 2;
            text.append(curr);
        }

        return kmp.KMPSearch(text.toString(),patternString.toString());
    }

}


class KMP {
    
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


