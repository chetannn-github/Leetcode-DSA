class Solution {
    public int maxSumMinProduct(int[] nums) {
        long pre[] = new long[nums.length+1];
        pre[0] = 0;
        for(int i=0; i<nums.length; i++){
            pre[i+1] = pre[i] + nums[i];
        }

        int nsi[] = findNextSmallerIndex(nums);
        int psi[] = findPreviousSmallerIndex(nums);
        
        long max= Long.MIN_VALUE;

        for(int i=0;i<nums.length; i++){
            int si = psi[i]+1;
            int ei = nsi[i];
            // find sum 
            long sum = pre[ei] - pre[si];
            long product =  sum * nums[i];
            max = Math.max(product, max);
        }
        return (int)(max % 1_000_000_007);

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
        System.out.println(Arrays.toString(nsi));
        return nsi;

    }
    public int[] findPreviousSmallerIndex(int[] nums){
        Stack<Integer> st = new Stack<>();
        int psi[] = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                psi[i] = -1;
            }else{
                psi[i] = st.peek();
            }
            st.push(i);
        }
        System.out.println(Arrays.toString(psi));

        return psi;
    }
}