class Solution {
    public String smallestString(String s) {
        int si = 0 , n = s.length();
        while(si < n  && s.charAt(si) == 'a') si++;

        if(si == n) return s.substring(0,n-1) + 'z';
        int ei = si + 1;

        while(ei < n && s.charAt(ei) != 'a') ei++;
        
        StringBuilder sb = new StringBuilder();

        for(int i = 0;  i<n; i++) {
            char ch = s.charAt(i);
            
            if(i >= si && i < ei) {
                char prev = (char) (ch - 1);
                sb.append(prev);
            }else sb.append(ch);
        }

        return sb.toString();
    }
}