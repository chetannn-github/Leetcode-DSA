class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) return "";
        
        StringBuilder sb = new StringBuilder();
        boolean firstChange = true;

        for(int i=0; i<n; i++) {
            char ch = palindrome.charAt(i);

            if(ch != 'a' && firstChange && i!= n/2) {
                sb.append('a');
                firstChange = false;
            }else sb.append(ch);
        }

        if(firstChange) {
            sb.setCharAt(n-1,'b');
        }

        return sb.toString();
    }
}