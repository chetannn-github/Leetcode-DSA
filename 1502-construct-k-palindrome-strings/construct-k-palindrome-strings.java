class Solution {
    public boolean canConstruct(String s, int k) {
        int[] freq = new int[26];

        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int odd = 0, even = 0;

        for(int i=0; i<26; i++) {
            even += freq[i] / 2;
            odd += freq[i] % 2;
        }

        if(odd > k) return false;
        if(2 * even + odd < k) return false;

        return true;
    }
}