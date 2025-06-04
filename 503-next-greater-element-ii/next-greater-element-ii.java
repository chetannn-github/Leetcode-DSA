class Solution {
    public int[] nextGreaterElements(int[] nums) {
    // one simple solution comes to my mind is first next greater then previous greater and compare them and tAKE BIGGER ONE.
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[nums.length];

        for(int i = 2*(nums.length) - 1; i>=0;i--){
            // for each i check in stack

            while(!st.isEmpty() && st.peek()<=nums[i%nums.length]){
                st.pop();
            }

            if(i<=nums.length-1){
            ans[i]=st.isEmpty()? -1:  st.peek();
           }
            
            st.push(nums[i%nums.length]);
        }
        return ans;

    }
}