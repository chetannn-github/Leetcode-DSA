class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int pLength = p.length();
        int sLength = s.length();
        if(sLength<pLength){return ans;}

        int[] pChar = new int[26];
        int[] slidingChar = new int[26];

        for(int i=0; i<pLength; i++){
            pChar[p.charAt(i) -'a']++;
            slidingChar[s.charAt(i) - 'a']++;
        }

        if(isAnagram(pChar, slidingChar)){
            ans.add(0);
        }

        for(int i=pLength; i<sLength;i++){
            slidingChar[s.charAt(i-pLength)-'a']--;
            slidingChar[s.charAt(i) -'a']++;
            
            if(isAnagram(pChar, slidingChar)){
                ans.add(i-pLength+1);
            }
            
        }
        return ans;
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