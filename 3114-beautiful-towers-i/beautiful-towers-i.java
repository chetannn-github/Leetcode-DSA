class Solution {
    int psi[];
    int nsi[];
    public long maximumSumOfHeights(int[] heights) {
        int n = heights.length;
        psi = new int[n];
        nsi = new int[n];

        findPreviousSmallerIndex(heights);
        findNextSmallerIndex(heights);

        

        long[] previousAns = new long[n];

        for(int i=0; i<n; i++) {
            int previousSmallerIdx = psi[i];
            int num = heights[i];

            previousAns[i] = (long) num * (i - (previousSmallerIdx + 1)) + (previousSmallerIdx == -1 ? 0 : previousAns[previousSmallerIdx]) + num;
        }


        long[] nextAns = new long[n];

        for(int i= n-1; i>=0; i--) {
            int nextSmallerIdx = nsi[i];
            int num = heights[i];

            nextAns[i] = (long) num * (nextSmallerIdx - 1 - i)  + (nextSmallerIdx == n ? 0 : nextAns[nextSmallerIdx]) + num;
        }
        

        long max = Long.MIN_VALUE;
        for(int i=0; i<n; i++) {
            long ans = (long) previousAns[i] - heights[i] + nextAns[i];
            max  = Math.max(max, ans);
        }

        return max;

    }


    public void findPreviousSmallerIndex(int[] heights) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<heights.length; i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            psi[i] = st.isEmpty() ? -1 : st.peek();
            
            st.push(i);
        }
    }
    public void findNextSmallerIndex(int[] heights) {
        Stack<Integer> st = new Stack<>();

        for(int i=heights.length-1; i>=0; i--) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            nsi[i] = st.isEmpty() ? heights.length : st.peek();
            
            st.push(i);
        }
    }
}