class Solution {
    HashMap<Character, String> hm = new HashMap<>();
    List<String> solutions = new ArrayList<>();
    int n;

    public List<String> letterCombinations(String digits) {

        n = digits.length();
        if(n==0){
            return solutions;
        }
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");

        StringBuilder sb = new StringBuilder();
        solve(digits, sb, 0);
        return solutions;
    }

    public void solve(String digits, StringBuilder sb , int start){
        if(sb.length() ==n){
            solutions.add(sb.toString());
            return ;
        }

        
            char ch = digits.charAt(start);
            String st = hm.get(ch);

            for(int j=0; j<st.length(); j++){
                sb.append(st.charAt(j));
                solve(digits,sb, start+1);
                sb.setLength(sb.length()-1);
            }
        

    }


}