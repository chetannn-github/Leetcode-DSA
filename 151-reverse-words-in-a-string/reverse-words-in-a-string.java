class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)!=' '){
                sb.append(s.charAt(i));
            }
            else if(sb.length()!=0 && s.charAt(i)==' ') {
                ans.append(sb.reverse()+" ");
                sb.setLength(0);
            }
        }
        if(sb.length() > 0) ans.append(sb.reverse()+" ");
                
        ans.setLength(ans.length()-1);
        return ans.toString();
    }
}