class Solution {
    public String minRemoveToMakeValid(String s) {
        int countClosing = 0;
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i=0; i<n; i++){
            if(s.charAt(i)==')'){countClosing++;}
        }

        int currCountOpening = 0;
        int currCountClosing = 0;

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            
            if(ch=='('){
                if(currCountOpening+1 <= countClosing-currCountClosing){
                    sb.append(ch);
                    currCountOpening++;
                }
            }else if(ch==')'){
                
                if(currCountOpening > 0){
                    sb.append(ch);
                    currCountOpening--;
                }
                currCountClosing++;
            }else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}