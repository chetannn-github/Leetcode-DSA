class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int maxArea = 0;
        for(int i=0; i<rows; i++) {
            if(i>0) {
                for(int j=0; j<cols; j++) {
                    int prev = matrix[i-1][j] - '0';
                    int curr = matrix[i][j] - '0';
                    matrix[i][j] = (char) ((prev + curr ) * curr + '0');
                }
            }
            maxArea = Math.max(maxArea,maxHistogram(matrix[i]));
        }
        return maxArea;
    }

    private int maxHistogram(char[] height) {
        int[] prevSmallerIdx = findPSI(height);
        int[] nextSmallerIdx = findNSI(height);
        int maxArea = 0;
        for(int i=0; i<height.length; i++) {
            int width = nextSmallerIdx[i] - prevSmallerIdx[i] - 1;
            int currArea = (height[i] - '0') * width;
            maxArea = Math.max(maxArea,currArea);
        }
        return maxArea;
    }

    private int[] findNSI(char[] arr) {
        int[] NSI = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=arr.length-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] - '0' >= arr[i] - '0') {
                st.pop();
            }
            NSI[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
            
        }
        return NSI;
    }

    private int[] findPSI(char[] arr) {
        int[] PSI = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<arr.length; i++) {
            while(!st.isEmpty() && arr[st.peek()] - '0' >= arr[i] - '0') {
                st.pop();
            }
            
            PSI[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return PSI;
    }
}