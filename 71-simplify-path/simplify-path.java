class Solution {
    // public String simplifyPath(String path) {
    //     int countDots = 0;
    //     Stack<Character> st = new Stack<>();

    //     for(int i = 0; i<path.length();i++){
    //         if(st.isEmpty()){st.push('/');}
    //         if( st.peek()=='/' && path.charAt(i)=='/'){
    //         // kuch mt kro
    //         }else if( path.charAt(i)=='.'){
    //             // check kro kii khii dot kisi directory ke naam m bhii ho skta hh naa
    //             if(countDots==0 &&st.peek()=='/'){
    //                 countDots++;
    //             }else if(countDots>0){
    //                 countDots++;
    //             }
    //             st.push('.');

    //         }else if(countDots == 1 && path.charAt(i)=='/'){
    //             // pop till / naa aajae.
    //             while(countDots!=0){
    //                 st.pop();
    //                 if(st.peek()=='/'){countDots--;}
                    
    //             }

    //         }else if(countDots == 2 && path.charAt(i)=='/'){
    //             //pop till stack khali ho jaaae yaa do baar / naa aaajae
    //             while(!st.isEmpty()&&countDots!=0){
    //                 st.pop();
    //                 if(st.isEmpty()){countDots=0;break;}
    //                 if(st.peek()=='/'){countDots--;}
                    
    //             }
    //         }else{
    //             st.push(path.charAt(i));
    //             countDots=0;
    //         }

    //     }
    //     if(countDots==2 && !st.isEmpty()){
    //          while(!st.isEmpty()&&countDots>0){
    //                 st.pop();
    //                 if(st.isEmpty()){break;}
    //                 if(st.peek()=='/'){countDots--;}
    //         }

    //     }else if(countDots==1 &&!st.isEmpty()){
    //             while(countDots!=0){
    //                 st.pop();
    //                 if(st.peek()=='/'){countDots--;}
                    
    //             }
    //     }

    //     if(st.size()==0 ||st.size()==1){
    //         return "/";
    //     }else if(st.peek()=='/'){
    //         st.pop();
    //         //last wala / hatane ke liye
    //     }
        

    //     StringBuilder sb = new StringBuilder();
    //     while(!st.isEmpty()){
    //         sb.append(st.pop());
    //     }

    //     return sb.reverse().toString();
    // }

    // 2nd approach of taking chunk into stack
   
    public String simplifyPath(String path) {
        Stack<String> st= new Stack<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("") || component.equals(".")) {
                continue;
            } else if (component.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(component);
            }
        }

        
        StringBuilder result = new StringBuilder();
        for (String dir : st) {
            result.append("/").append(dir);
        }

        
        return result.length() > 0 ? result.toString() : "/";
    }
}