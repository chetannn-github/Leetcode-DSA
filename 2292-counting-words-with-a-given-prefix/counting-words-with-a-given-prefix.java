class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for(String word : words){
            if(word.length()< pref.length()){continue;}

            if(checkPrefix(word, pref))count++;
        }

        return count;
    }

    public boolean checkPrefix(String word, String pref){
        for(int i=0; i<pref.length();i++){
            if(word.charAt(i)!=pref.charAt(i)){
                return false;
            }
        }

        return true;
    }
}