class Solution {
    int result = 0;
    int count ;
    

    public String getHappyString(int n, int k) {
        count = k;
        solve(n,0);

        if(result==0){
            return new String("");
        }
        StringBuilder sb = new StringBuilder();
        while(result!=0){
            int last = result%10;
            if(last == 1){
                sb.append("a");
            }else if(last == 2){
                sb.append("b");
            }else{
                 sb.append("c");
            }
            result /=10;
        }

        return sb.reverse().toString();
    }


    public void solve(int length , int temp){
        int digits = (int) Math.log10(temp) +1;
        if(result!=0){
            return;
        }
        if(digits == length){
            count--;
            if(count==0){
                result = temp;
                return;
            }else{
                return;
            }
        }

        for(int i=1; i<=3; i++){
            int last = temp%10;
            if(last==i){
                continue;
            }
            temp = temp*10 + i;
            

            solve(length,temp);

            
            temp /=10;
            

        }
    }
}