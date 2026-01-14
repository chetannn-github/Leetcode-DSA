class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        return getNextGreaterIdx(heights);
    }

    private int[] getNextGreaterIdx(int[] nums) {
        int n = nums.length;
        int[] ngi = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--) {
           
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                ngi[i]++;
                st.pop();
            }
            ngi[i] += (!st.isEmpty() && nums[st.peek()] > nums[i]) ? 1 :   st.size();
           
            st.push(i);
        }

        return ngi;
    }
}