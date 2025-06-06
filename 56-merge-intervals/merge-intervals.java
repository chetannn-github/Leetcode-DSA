class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr,(a,b)->(a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]));
        Stack<int[]> st = new Stack<>();

        for(int i = 0; i< arr.length; i++) {
            if(!st.isEmpty() && st.peek()[1] >= arr[i][0]){
                int start = st.peek()[0];
                int end = Math.max(arr[i][1], st.pop()[1]);

                st.push(new int[]{start,end});
            }else {
                st.push(arr[i]);
            }
            
        }
        int[][] ans = new int[st.size()][2];
        int idx = 0;
        while(!st.isEmpty()){
            ans[idx++] = st.pop();
        }
        
        return ans;
    }
}