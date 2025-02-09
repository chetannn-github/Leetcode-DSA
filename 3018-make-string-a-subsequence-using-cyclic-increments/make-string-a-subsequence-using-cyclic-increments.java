class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int start = 0;

        for(int i=0; i<str1.length(); i++){
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(start);

            int dif = (ch2 -  ch1) %26;

            if(dif==0 || dif==1 || dif== -25 ){
                start++;
            }
            if(start == str2.length()){
                return true;
            }
        }

        return false;
    }
}