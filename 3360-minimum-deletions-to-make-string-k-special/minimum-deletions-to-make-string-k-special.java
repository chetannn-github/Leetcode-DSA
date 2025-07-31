class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for(char ch : word.toCharArray()) {
            freq[ch-'a']++;
        }
        Arrays.sort(freq);
        int minOps = Integer.MAX_VALUE;
        int preSum = 0;

        for(int i=0; i<26; i++) {
            if(freq[i] == 0) continue;
            int ops = preSum;
            preSum += freq[i];
            
            for(int j=i+1; j<26; j++) {
                if(freq[j] - freq[i] > k) {
                    ops += freq[j] - freq[i] - k;
                }
            }

            minOps = Math.min(minOps,ops);
            
        }

        return minOps;
    }
}