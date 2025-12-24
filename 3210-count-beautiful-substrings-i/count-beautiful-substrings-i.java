class Solution {
    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        int[] vowels = new int[n+1];
        int[] consonants = new int[n+1];

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            vowels[i+1] = vowels[i] + (isVowel(ch) ? 1 : 0);
            consonants[i+1] = consonants[i] + (!isVowel(ch) ? 1 : 0);
        }  

        int count = 0;

        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                int vowelCount = vowels[j+1] - vowels[i];
                int consonantCount = consonants[j+1] - consonants[i];

                if(vowelCount == consonantCount  && ((vowelCount * vowelCount) % k) == 0) count++;
            }
        }

        return count;
    }


    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}