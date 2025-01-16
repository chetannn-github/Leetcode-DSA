// class Solution {
//     public boolean isPowerOfThree(int n) {

//          return ( n>0 &&  1162261467%n==0);
//         // if(n==1){return true;}
//         // while(n>3){
            
//         //     if(n%3!=0){
//         //         return false;
//         //     }
//         //     n/=3;
//         // }
//         // return n==3;
//     }
// }
class Solution {
    public boolean isPowerOfThree(int n) {

         if(n<=0){
            return false;
        }else if(n==1){
            return true;
        }
        return n%3 ==0 && isPowerOfThree(n/3);
    }
}