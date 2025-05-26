// class Solution {
//     public int findKthPositive(int[] arr, int k) {
//         int[] isPresent = new int[1001];

//         for(int num : arr) {
//             isPresent[num] = 1;
//         }
//         int i=1;
//         for(; i<1001; i++) {
//             int num = isPresent[i];
//             if(num == 0) {
//                 k--;
//                 if(k == 0) {
//                     return i;
//                 }
//             }
//         }

//         while(k-->0) { i++;
//         }
//         return i -1;


//     }
// }




class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missingCount = 0;
        int currentNum = 1;
        int i = 0;

        while (missingCount < k) {
            
            if (i < arr.length && arr[i] == currentNum) {
                i++;
            } else {
                missingCount++;
                if (missingCount == k) {
                    return currentNum;
                }
            }
            currentNum++;
        }
        return -1; 
        
    }
}