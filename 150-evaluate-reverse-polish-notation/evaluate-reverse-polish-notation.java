class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(int i =0; i<tokens.length; i++){
            Boolean isOperator = (tokens[i].equals("+") )||(tokens[i].equals("-") )||(tokens[i].equals("*") )||(tokens[i].equals("/") );

            if(isOperator){
                // last ke 2 numbers pop kro stack se aur solve krke push krdo
                int second = st.pop();
               
                if(tokens[i].equals("+")){
                     st.push(st.pop() + second);
                }else if(tokens[i].equals("-")){
                     st.push(st.pop() - second);
                }else if(tokens[i].equals("*")){
                     st.push(st.pop() *second);
                }else {
                     st.push(st.pop() / second);
                }
               

            }else{
                st.push(parseInteger(tokens[i]));
            }
        }

        return st.pop();
    }


    public int parseInteger(String s) {
        int result = 0;
        boolean isNegative = false;

        for(int i=0; i< s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '-') {
                isNegative = true;
                continue;
            }else if (ch == '+') continue;
            int digit = ch - '0';

            result = result * 10 + digit ;
        }

        return isNegative ? -1 * result : result;
    }
}