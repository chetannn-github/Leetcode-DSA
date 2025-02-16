// class Solution {
//     public boolean isPowerOfFour(int n) {
//         if(n<=0){
//             return false;
//         }else if(n==1){
//             return true;
//         }
//         return n%4 ==0 && isPowerOfFour(n/4);
//     }
// }



class Solution {
    public boolean isPowerOfFour(int n) {

        if(n<=0)
        {
            return false;
        }
       return ((n & (n-1))==0 && (n-1)%3==0);
    }
}