// class Solution {
//     public int[] decode(int[] encoded) {
//         int n = encoded.length +1;
//         int perm[] = new int[n];
        
//         for(int j=1; j<=n; j++){
//             int possibleAns = encoded[0] ^ j;
//             if(possibleAns>0 && possibleAns <=n){
//                 perm[1] = j;
//                 perm[0] = possibleAns;
//                 boolean flag = true;
//                 for(int i = 1; i<n-1; i++){
//                     perm[i+1] = perm[i] ^ encoded[i];
//                     if(perm[i+1]==0 || perm[i+1]>n){
//                         flag = false;
//                         break;
//                     }
//                 }

//                 if(flag) return perm;
//             }            
//         }
        
        

//         return perm;
//     }
// }

// pura game first element nikalne kaa thaa
class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length +1;
        int perm[] = new int[n];

        int first = 0;
        for(int i=1; i<=n; i++){
            first ^= i;      
        }

        for(int i=1; i<n-1; i+=2){
            first ^= encoded[i];
        }
        perm[0] = first;

        for(int i = 1; i<n; i++){
            perm[i] = perm[i-1] ^ encoded[i-1];
        }
        

        return perm;
    }
}