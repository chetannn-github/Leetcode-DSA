class Solution {
    public int minDeletions(String s) {
        int[] charFreq = new int[26];
        int maxCharFreq = 0;

        for(char ch : s.toCharArray()) {
            charFreq[ch-'a']++;
            maxCharFreq = Math.max(maxCharFreq, charFreq[ch-'a']);
        }



        int[] freq = new int[maxCharFreq+1];

        for(int i=0; i<26; i++) {
            freq[charFreq[i]]++;
        }
        
        int n = freq.length;
        int ops = 0;
        for(int i= n-1; i>0 ; i--) {
            if(freq[i] > 1) {
                ops += freq[i] - 1;
                freq[i-1] += freq[i] - 1;
            }
        }

        return ops;


    }
}