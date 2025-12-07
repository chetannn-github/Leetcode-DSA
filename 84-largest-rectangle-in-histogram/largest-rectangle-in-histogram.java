class Solution {
    public int largestRectangleArea(int[] height) {
        int[] prevSmallerIdx = findPSI(height);
        int[] nextSmallerIdx = findNSI(height);
        int maxArea = 0;
        for(int i=0; i<height.length; i++) {
            int width = nextSmallerIdx[i] - prevSmallerIdx[i] - 1;
            int currArea = height[i] * width;
            maxArea = Math.max(maxArea,currArea);
        }
        return maxArea;
    }

    private int[] findNSI(int[] arr) {
        int[] NSI = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=arr.length-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            NSI[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
            
        }
        return NSI;
    }

    private int[] findPSI(int[] arr) {
        int[] PSI = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<arr.length; i++) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            
            PSI[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return PSI;
    }
}