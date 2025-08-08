class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        return solve(s1,s2,true);
    }

    private int findGreaterOREqualFreq(int[] arr,int target) {
        for(int i = target ; i<26; i++) {
            if(arr[i] != 0) return i;
        }

        return -1;
    }


    public boolean solve(String s1, String s2, boolean isFirstTime) {
        int[] freq = new int[26];
        int n = s1.length();

        for(int i=0; i<n; i++) {
            freq[s2.charAt(i) - 'a']++;
        }

        for(int i=0; i<n; i++) {
            int justGreaterOREqualCharIdx = findGreaterOREqualFreq(freq,s1.charAt(i) - 'a');

            if(justGreaterOREqualCharIdx == -1) {
                return isFirstTime && solve(s2,s1,false);
            }

            freq[justGreaterOREqualCharIdx]--;
        }

        return true;
    }
}