class Solution {
    public String removeOuterParentheses(String s) {
        // Stack<Character> st = new Stack<>();
         StringBuilder sb = new StringBuilder();
        // phele sabko stack m  insert kroo 
        //then check kroo kii do closing ya do opening saath me yhh toh ek ko hata do
        // for(int i = 0; i<s.length();i++){
        //     if(st.isEmpty() ){
        //         st.push(s.charAt(i));
        //     }else if(!st.isEmpty() && s.charAt(i)=='('){
        //         st.push(s.charAt(i));
        //         sb.append(s.charAt(i));
                
        //     }
        //     else {
        //             char top = st.pop();
        //             if(!st.isEmpty()){
        //                 sb.append(s.charAt(i));
        //             }
                   
                   

        //     }
        // }
        int count = 0;
        for(int i = 0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(') {
                count++;
                if(count > 1) sb.append(ch);
            }else {
                count--;
                if(count != 0) sb.append(ch);
                
            }

            
        }
        return sb.toString();
    }
}