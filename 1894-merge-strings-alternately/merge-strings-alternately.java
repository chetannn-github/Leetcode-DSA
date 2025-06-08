class Solution {
    public String mergeAlternately(String word1, String word2) {
       StringBuilder sb = new StringBuilder();
        int l1 = word1.length();
        int l2 = word2.length();
        int min= Math.min(l1,l2);
        
        for(int i=0; i<min ; i++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if(l1<l2){
            sb.append(word2.substring(l1));
        }else if(l1>l2){
            sb.append(word1.substring(l2));
        }

        return sb.toString();

    }
}