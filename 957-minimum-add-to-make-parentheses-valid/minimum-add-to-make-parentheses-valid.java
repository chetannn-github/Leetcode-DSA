class Solution {
    public int minAddToMakeValid(String s) {

        // wrong approach kuki mere liye paranthesis ke count nhii unka order bhii impp hhh ()))((
        int ans =0;
        // for(int i =0 ; i<s.length(); i++){
        //     if(s.charAt(i)=='('){ans++;}
        //     else{ans--;}
        // }
        // return Math.abs(ans) ;

        Stack<Character> st = new Stack<>();

         for (int i =0 ; i<s.length(); i++){
            if (s.charAt(i)=='(') st.push('(');
            else {
                if (!st.isEmpty()) st.pop();
                else ans++; 
            }
        }

        
        return ans + st.size();
        
        // we can do without using stack also
        // int openCount =0;

        //  for(int i =0 ; i<s.length(); i++){
        //     if(s.charAt(i)=='('){openCount++;}
        //     else{
        //         if(openCount!=0){openCount--;}
        //         else{ans++;}
        //     }
           
        // }
        // return ans + openCount;


    }
}