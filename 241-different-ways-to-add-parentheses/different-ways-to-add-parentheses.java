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