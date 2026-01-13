class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] psi = getPreviousSmallerIdx(nums);
        int[] nsi = getNextSmallerIdx(nums);

        int maxScore = nums[k];
        for(int i=0; i<n; i++) {
            boolean isContainsK = (psi[i]+1 <= k  && nsi[i]-1 >= k);

            if(isContainsK) {
                int currScore = nums[i] * (nsi[i]-psi[i]-1);
                maxScore = Math.max(maxScore,currScore);
            }
        }

        return maxScore;
    }

    private int[] getPreviousSmallerIdx(int[] nums) {
        int n = nums.length;
        int[] psi = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            psi[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return psi;
    }

    private int[] getNextSmallerIdx(int[] nums) {
        int n = nums.length;
        int[] nsi = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            nsi[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nsi;
    }
}