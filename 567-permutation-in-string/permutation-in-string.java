class Solution {
    public boolean checkInclusion(String p, String s) {
        int pLength = p.length();
        int sLength = s.length();
        if(sLength<pLength){return false;}

        int[] pChar = new int[26];
        int[] slidingChar = new int[26];

        for(int i=0; i<pLength; i++){
            pChar[p.charAt(i) -'a']++;
            slidingChar[s.charAt(i) - 'a']++;
        }

        if(isAnagram(pChar, slidingChar)){
            return true;
        }

        for(int i=pLength; i<sLength;i++){
            slidingChar[s.charAt(i-pLength)-'a']--;
            slidingChar[s.charAt(i) -'a']++;
            
            if(isAnagram(pChar, slidingChar)){
              return true;
            }
            
        }
        return false;
    }

    public boolean isAnagram(int[] pChar, int[] slidingChar ){
        boolean isAnagram = true;

        for(int i=0; i<26; i++){
            if(pChar[i] != slidingChar[i]){
                return false;
            }
        }

        return true;
    }
}