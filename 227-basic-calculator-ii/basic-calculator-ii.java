class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if(isNumber(ch)) {
                int num = ch - '0';

                while(true){
                    if(i+1 < n && isNumber(s.charAt(i+1)) ){
                        i++;
                        num = num * 10 + (s.charAt(i) - '0');
                    }else {
                        break;
                    }
                }
                if(!ops.isEmpty() && isMulDiv(ops.peek())){
                    int num1 = num;
                    int num2 = st.pop();
                    char operator = ops.pop();
                    int result = operator  == '*' ? (num1 * num2) : (num2 / num1);
                    st.push(result);

                }else{
                    if(!ops.isEmpty()){
                        if(ops.peek() == '+') st.push(num);
                        else st.push(-num);
                    }else {
                        st.push(num);
                    }
                    
                }
                
            }else if(isOperator(ch)){
                ops.push(ch);
            }
        }
        int result = 0;
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }


    public boolean isNumber(char ch){
        return ch - '0' >= 0 && ch - '0' <= 9;
    }
    public boolean isMulDiv (char ch) {
        return  ch == '*' || ch == '/';
    }

    public boolean isOperator (char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

}