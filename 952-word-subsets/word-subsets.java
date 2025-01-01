class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> subsets = new ArrayList<>();
        int[] freq = new int[26];

        for(String word : words2){
            int[] temp = new int[26];
            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);
                temp[(int)(ch-'a')]++;
                
            }

            for(int i=0; i<26; i++){
                freq[i] = Math.max(freq[i], temp[i]);
            }
        }

        for(String word : words1){
            if(checkIsSubsets(word, freq)){
                subsets.add(word);
            }
        }
        return subsets;
    }

    public boolean checkIsSubsets(String word, int[] freq){
        int[] freqCopy = new int[freq.length];
        for(int i=0; i<26; i++){
            freqCopy[i] = freq[i];
        }
        
        for(int i=0; i<word.length(); i++){ 
            char ch = word.charAt(i);
            int idx = (int)(ch-'a');
            
            if(freqCopy[idx] !=0){ 
                freqCopy[idx]--;
            }
        }

        for(int f : freqCopy){
            if(f!=0) return false;
        } 
        return true;
    }
}