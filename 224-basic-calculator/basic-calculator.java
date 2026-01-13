class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Pair> st = new Stack<>();
        

        int currNum = 0;
        int previousOperator = 1;

        int currResult = 0;
        st.push(new Pair(currResult,true));

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if(ch == ' ') continue;

            if(isNumber(ch)) {
                currNum = currNum*10 + (ch-'0');

            }else if(isOperator(ch)) {
                st.peek().val += currNum * previousOperator ;
                currNum = 0;
                previousOperator = ch == '+' ? 1 : -1;

            }else {
                if(ch == '(') {
                    st.push(new Pair(0,previousOperator == 1));
                    currNum = 0;
                    previousOperator = 1;
                }else {
                    st.peek().val += currNum * previousOperator ;
                    Pair curr = st.pop();
                    st.peek().val += (curr.isPositive) ? curr.val : -curr.val;
                    currNum = 0;
                    previousOperator = 1;
                }
            }
        }

        st.peek().val += currNum * previousOperator ;
        return st.peek().val;
    }

    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }
    private boolean isOperator(char ch) {
        return ch=='+' || ch == '-';
    }
}

class Pair{
    int val;
    boolean isPositive;

    Pair(int val, boolean isPositive) {
        this.val = val;
        this.isPositive = isPositive;
    }
}