// class Solution {
//     public long minimumSteps(String s) {
//         int zeroPointer =-1;
//         long ans =0;
//         for(int i=s.length()-1; i>=0; i--){
//             if(zeroPointer==-1 && s.charAt(i) == '0'){
//                 zeroPointer = i;
//             }else if(zeroPointer!=-1 && s.charAt(i)=='1'){
//                 ans += (zeroPointer-i);
//                 zeroPointer--;
//             }
//         }

//         return ans;
//     }
// }
class Solution {
    public long minimumSteps(String s) {
        int zeroPointer =0;
        long ans =0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0'){
                ans += (i-zeroPointer);
                zeroPointer++;
            }
        }
        return ans;
    }
}