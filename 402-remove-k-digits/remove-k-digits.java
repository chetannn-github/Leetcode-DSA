class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length()){return "0";}
        
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i<num.length();i++){
            while(k>0 && !st.isEmpty() && st.peek().compareTo(num.charAt(i))>0){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
            
        }
        // jab sare ascending order me hooo 
        while(k>0){
            st.pop();
            k--;
        }



        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        while(sb.length() !=1 && sb.charAt(sb.length()-1)=='0'){
            sb.deleteCharAt(sb.length()-1); 
        }
        return sb.reverse().toString();
    }
}