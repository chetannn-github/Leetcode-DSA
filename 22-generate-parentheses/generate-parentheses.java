class Solution {
    List<String> result ;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        solve(n,n, new StringBuilder());
        return result;
    }

    public void solve(int open, int close, StringBuilder temp) {
        if(open == 0 && close == 0) {
            result.add(temp.toString());
            return;
        }


        if(close > open) {
            temp.append(")");
            solve(open, close-1, temp);
            temp.setLength(temp.length()-1);
        }
        if(open > 0) {
            temp.append("(");
            solve(open - 1, close, temp);
            temp.setLength(temp.length()-1);
        }
        


    }
}