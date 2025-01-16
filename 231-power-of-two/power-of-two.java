// class Solution {
//     public boolean isPowerOfTwo(int n) {
//       if (n<=0){return false;}
//       else{
//      boolean bt = ((n&(n-1)) == 0 );
//      return bt;}
//     }
// }

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }else if(n==1){
            return true;
        }
        return n%2 ==0 && isPowerOfTwo(n/2);
    }
}