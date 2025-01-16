// class Solution {
//     public double myPow(double x, int n) {
        
//         if(n==0){
//             return 1;
//         }

//         if(n>0){
//             return x * myPow(x,n-1);
//         }else{
//             return 1/x * myPow(1/x, -n-1);
//         }

        
//     }
// }


class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        if(x==1){
            return 1;
        }
        long absN = Math.abs((long) n);
        double ans=1.0;
        while(absN > 0){
            if(absN%2==1){
                ans*=x;
            }
            x*=x;
            absN/=2;
        }
        return n < 0 ? 1/ans : ans;
    }
}