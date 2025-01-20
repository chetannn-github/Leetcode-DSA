class Solution {
    List<String> result = new ArrayList<>();
    int n;
    public List<String> letterCasePermutation(String s) {
        StringBuilder temp = new StringBuilder();
        n = s.length();
        solve(s,temp,0);

        return result;
    }

    public void solve(String s, StringBuilder sb,int start){
        if(sb.length()==n ){
            result.add(sb.toString());
            return;
        }

        
            char ch = Character.toLowerCase(s.charAt(start));
            
            if(isNonDigit(ch)){
                sb.append(ch);
                solve(s,sb,start+1);
                sb.setLength(sb.length()-1);

                ch = Character.toUpperCase(s.charAt(start));
                sb.append(ch);
                solve(s,sb,start+1);
                sb.setLength(sb.length()-1);


            }else{
                sb.append(ch);
                solve(s,sb,start+1);
                sb.setLength(sb.length()-1);
            }
        
    }


    public boolean isNonDigit(char ch){
        return (ch>='a' && ch<='z' ) ;
    }
}