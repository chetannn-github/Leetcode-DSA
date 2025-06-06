class Solution {
    public int scoreOfParentheses(String s) {
        int ans  = 0 ,opening = 0; 

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                opening++;
            }else {
                if(s.charAt(i-1)=='(') ans += Math.pow(2,opening-1);
                opening--;
            }
        }
        return ans;
    }
}