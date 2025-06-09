class Solution {
    public String makeSmallestPalindrome(String s) {
        int start = 0; 
        int end = s.length()-1;
        char[] charArray = s.toCharArray();

        while(start<end){
            if(charArray[start] > charArray[end]){
                charArray[start] = charArray[end];
            }else if(charArray[start]< charArray[end]){
                charArray[end] = charArray[start];
            } 

            start++;
            end--;
        }

        return new String(charArray);
    }
}

