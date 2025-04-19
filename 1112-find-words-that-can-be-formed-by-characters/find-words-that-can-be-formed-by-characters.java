class Solution {
    public int countCharacters(String[] words, String chars) {
        int freq[] = new int[26];

        for(int i=0; i<chars.length(); i++){
            freq[chars.charAt(i) - 'a']++;
        }

        int count = 0;
        for(String word : words){
            int[] localFreq = new int[26];
            int length = word.length();
            for(int i=0; i<length; i++){
                localFreq[word.charAt(i) - 'a']++;
            }
            boolean canMade = true;
            for(int i=0; i<26; i++){
                if(localFreq[i] > freq[i]){
                    canMade = false;
                    break;
                }
            }
            if(canMade) count += length;
        }

        return count;


    }
}