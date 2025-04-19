class Solution {
    public List<String> commonChars(String[] words) {
        int[] freq = new int[26];
        boolean firstTime = true;

        for(String word : words){
            int[] localFreq = new int[26];

            for(int i=0; i<word.length(); i++){
                int ch = word.charAt(i) - 'a';
                localFreq[ch]++;
            }
            
            
                for(int i=0; i<26; i++){
                    if(!firstTime){
                        freq[i] = Math.min(freq[i],localFreq[i]);
                    }else{
                        freq[i] = localFreq[i];
                    }
                }

            firstTime = false;
            
        }
        List<String> ans = new ArrayList<>();
        for(int i=0; i<26; i++){
            while(freq[i]-->0){
                ans.add((char)(i+'a') + "");
            }
        }

        return ans;
    }
}