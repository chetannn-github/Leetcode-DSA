class Solution {

    public String reverseParentheses(String s) {
        // plan is simple jb bhii closing bracket mile 
        // usse just phele ( tk string ko reverse krdooo
        Stack<Integer> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '(') {
               st.push(ans.length());
            }else if (ch == ')'){
                int start = st.pop();
                reverse(ans, start, ans.length() - 1);
            }else {
                ans.append(ch);
            }
        }

        return ans.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);

            start++;
            end--;
        }
    }
}