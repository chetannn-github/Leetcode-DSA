class Solution {
    public int sumSubarrayMins(int[] nums) {
       
        int nsi[] = findNextSmallerIndex(nums);
        int psi[] = findPreviousSmallerIndex(nums);
        long sum =0;

        for(int i=0;i<nums.length; i++){
            int si = psi[i] + 1;
            int ei = nsi[i] - 1;
            // find sum 
            long subarraysIamMinumum = (long) (i-si+1)*(ei+1-i);
            sum = sum + (long) (nums[i])*(subarraysIamMinumum);
        }
        return (int)(sum % 1_000_000_007) ;

    }

    public int[] findNextSmallerIndex(int[] nums){
        Stack<Integer> st = new Stack<>();
        int nsi[] = new int[nums.length];

        for(int i=nums.length-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsi[i] = nums.length;
            }else{
                nsi[i] = st.peek();
            }
            st.push(i);
        }
        // System.out.println(Arrays.toString(nsi));
        return nsi;

    }
    public int[] findPreviousSmallerIndex(int[] nums){
        Stack<Integer> st = new Stack<>();
        int psi[] = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                psi[i] = -1;
            }else{
                psi[i] = st.peek();
            }
            st.push(i);
        }
        // System.out.println(Arrays.toString(psi));

        return psi;
    }
    }


// class Solution {
//     public int sumSubarrayMins(int[] arr) {
//         int sum = 0;
           
//         for(int i = 0; i<arr.length; i++){
//             int min = arr[i];
//             for(int j = i; j<arr.length; j++){
//                 min = Math.min(min,arr[j]);
//                 sum += min; 
//             }
//             sum = sum%1000000007;
//         }
//         return sum;
//     }
// }