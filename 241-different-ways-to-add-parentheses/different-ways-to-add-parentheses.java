class Solution {
    public List<Integer> diffWaysToCompute(String exp) {
        List<Integer> solutions = new ArrayList<>();
        int n = exp.length();

        for(int i=0; i<n; i++){
            char ch = exp.charAt(i);

            if(ch=='+' || ch=='-' || ch=='*'){
                List<Integer> left = diffWaysToCompute(exp.substring(0,i));
                List<Integer> right = diffWaysToCompute(exp.substring(i+1));

                for(Integer num1 : left){
                    for(Integer num2 : right){
                        if (ch == '+') solutions.add(num1 + num2);
                        else if (ch == '-') solutions.add(num1 - num2);
                        else solutions.add(num1 * num2);
                    }
                }
            }
        }
        if(solutions.size()==0){
            solutions.add(Integer.parseInt(exp));
        }
        return  solutions;
    }

    

}

// class Solution {
//     public List<Integer> diffWaysToCompute(String exp) {
//         int n = exp.length();
        
//         return solve(exp,0,n);
//     }

//     public List<Integer> solve(String exp,int start, int end) {
//         List<Integer> solutions = new ArrayList<>();

//         for(int i=start; i<end; i++){
//             char ch = exp.charAt(i);

//             if(ch=='+' || ch=='-' || ch=='*'){
//                 List<Integer> left = solve(exp,start,i);
//                 List<Integer> right = solve(exp,i+1, end);

//                 for(Integer num1 : left){
//                     for(Integer num2 : right){
//                         if (ch == '+') solutions.add(num1 + num2);
//                         else if (ch == '-') solutions.add(num1 - num2);
//                         else solutions.add(num1 * num2);
//                     }
//                 }
//             }
//         }

//         if(solutions.size()==0){
//             solutions.add(Integer.parseInt(exp.substring(start,end)));
//         }
//         return solutions;
//     }

// }