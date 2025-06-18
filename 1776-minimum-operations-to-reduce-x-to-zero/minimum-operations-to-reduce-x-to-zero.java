class Solution {
    public int minOperations(int[] nums, int x) {
        // cyclic array banakrr esii min length ki subarray jiska sum x ho simple
        // second idea can be kii aap total sum me se x hata de aur utne sum ka max subarray find krr le aur
        // baad uss length ho total se hata de
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int n = nums.length;
        int sum = 0;

        for(int end=0; end<2*n; end++){
            sum += nums[end%n];

            while(sum>x){
                sum -= nums[start%n];
                start++;
                
            }
            boolean isFromStart =  (start ==0 && end<n ) ;
            boolean isEndIncluded = (start<=n-1 && end>=n-1);
            boolean isNonDuplicate = (end - start + 1 <= n);

            if(sum ==x && isNonDuplicate && (isFromStart || isEndIncluded)){
                minLength = Math.min(end-start+1, minLength);
                
            }
            

            if(start>n){
                break;
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}


// class Solution {
//     public int minOperations(int[] nums, int k) {
//         int start = 0;
//         int minLength = -1;
//         int n = nums.length;
//         int sum = 0;
//         int lastFromStart = -1;
//         int currLength = 0;

//         for(int i=0; i<n; i++){
//             sum += nums[i];

//             if(sum>k){
//                 sum -= nums[i];
//                 lastFromStart = i-1;
//                 break;
//             }
//             if(sum==k){
//                 minLength = i +1;
//             }
//             lastFromStart = i;
//             currLength = i+1;
//         }

//         if(lastFromStart==n-1){
//             return minLength;
//         }

//         for(int end=n-1;end>=0; end--){
//             sum += nums[end];
//             currLength++;

//             while(sum>k){
//                 currLength--;
//                 if(lastFromStart>=0){
//                     sum -= nums[lastFromStart--];
//                 }else{
//                     return minLength;
//                 } 
//             }

//             if(sum==k){
//                 minLength = minLength==-1? currLength : Math.min(minLength,currLength);
//             }

//         }

        

//         return minLength;
//     }
// }